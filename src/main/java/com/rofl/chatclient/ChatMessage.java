package com.rofl.chatclient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage {

    @NotNull
    private String messageContent;
    @NotNull
    private String timeStamp;
    @NotBlank
    private String sender;
}
