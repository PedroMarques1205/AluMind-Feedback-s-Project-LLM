package com.alumind.alumindfeedbacksprojectllm.core;

import com.alumind.alumindfeedbacksprojectllm.common.enums.Sentiment;
import com.alumind.alumindfeedbacksprojectllm.common.utils.FeedbackResponseDTO;
import com.alumind.alumindfeedbacksprojectllm.common.utils.RequestedFeatureDTO;
import com.alumind.alumindfeedbacksprojectllm.dataprovider.feedback.IFeedbackResponseRepository;
import com.alumind.alumindfeedbacksprojectllm.dataprovider.feedback.IRequestedFeatureRepository;
import com.alumind.alumindfeedbacksprojectllm.model.feedback.FeedbackResponse;
import com.alumind.alumindfeedbacksprojectllm.model.feedback.RequestedFeature;
import lombok.AllArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class FeedbackService {

    @Autowired
    private IFeedbackResponseRepository feedbackResponseRepository;

    @Autowired
    private IRequestedFeatureRepository featureRepository;

    private final ChatClient chatClient;

    public FeedbackService(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    public FeedbackResponseDTO analyzeFeedback(String feedbackRequest) {
        String promptText = "Analise o seguinte feedback: \"" + feedbackRequest +
                "\". Determine se o sentimento é positivo, negativo ou inconclusivo e identifique quaisquer funcionalidades sugeridas. Use o seguinte formato e o reproduza exatamente:'Funcionalidade sugerida: <código_da_funcionalidade> - Motivo: <descrição_do_motivo>. Responda somente com esse formato mas não esqueça de dizer se é positivoo negativo ou inconclusivo.";

        PromptTemplate promptTemplate = new PromptTemplate(promptText);
        List<Generation> response = chatClient.prompt(promptTemplate.create()).call().chatResponse().getResults();

        FeedbackResponse feedbackResponse = new FeedbackResponse();
        feedbackResponse.setSentiment(extractSentiment(response));
        List<RequestedFeature> requestedFeatures = extractRequestedFeatures(response);
        feedbackResponse.setRequestedFeatures(extractRequestedFeatures(response));

        FeedbackResponseDTO responseDTO = new FeedbackResponseDTO();
        responseDTO.setId(feedbackResponse.getId());
        responseDTO.setSentiment(feedbackResponse.getSentiment().name());
        responseDTO.setRequestedFeatures(feedbackResponse.getRequestedFeatures().stream().map(feature -> {
            RequestedFeatureDTO dto = new RequestedFeatureDTO();
            dto.setCode(feature.getCode());
            dto.setReason(feature.getReason());
            return dto;
        }).collect(Collectors.toList()));

        return responseDTO;
    }

    private Sentiment extractSentiment(List<Generation> response) {
        for (Generation generation : response) {
            String content = generation.getOutput().getContent().toLowerCase();
            if (content.contains("positivo")) {
                return Sentiment.POSITIVO;
            } else if (content.contains("negativo")) {
                return Sentiment.NEGATIVO;
            }
        }
        return Sentiment.INCONCLUSIVO;
    }

    private List<RequestedFeature> extractRequestedFeatures(List<Generation> response) {
        List<RequestedFeature> features = new ArrayList<>();
        Pattern pattern = Pattern.compile("Funcionalidade sugerida:\\s*(.*?)\\s*-\\s*Motivo:\\s*(.*)");

        for (Generation generation : response) {
            String content = generation.getOutput().getContent();

            String[] lines = content.split("\n");
            for (String line : lines) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String featureCode = formatToUpperCaseWithUnderscore(matcher.group(1).trim());
                    String reason = matcher.group(2).trim();

                    features.add(new RequestedFeature(featureCode, reason));
                }
            }
        }

        return features;
    }

    private String formatToUpperCaseWithUnderscore(String input) {
        return input
                .replaceAll("([a-z])([A-Z])", "$1_$2")
                .replaceAll("[\\s-]+", "_")
                .toUpperCase();
    }

}
