/*
 * Hidden Switch Spellsource API
 * The Spellsource API for matchmaking, user accounts, collections management and more.  To get started, create a user account and make sure to include the entirety of the returned login token as the X-Auth-Token header. You can reuse this token, or login for a new one.  ClientToServerMessage and ServerToClientMessage are used for the realtime game state and actions two-way websocket interface for actually playing a game. Envelope is used for the realtime API services. 
 *
 * OpenAPI spec version: 2.1.0
 * Contact: ben@hiddenswitch.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.hiddenswitch.spellsource.client.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Send a change message to the indicated conversationId. 
 */
@ApiModel(description = "Send a change message to the indicated conversationId. ")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)

public class EnvelopeMethodSendMessage implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("conversationId")
  private String conversationId = null;

  @JsonProperty("message")
  private String message = null;

  public EnvelopeMethodSendMessage conversationId(String conversationId) {
    this.conversationId = conversationId;
    return this;
  }

   /**
   * A conversation ID looks like userId1,userId2 where the first user ID is the one that comes first lexicographically. 
   * @return conversationId
  **/
  @ApiModelProperty(value = "A conversation ID looks like userId1,userId2 where the first user ID is the one that comes first lexicographically. ")
  public String getConversationId() {
    return conversationId;
  }

  public void setConversationId(String conversationId) {
    this.conversationId = conversationId;
  }

  public EnvelopeMethodSendMessage message(String message) {
    this.message = message;
    return this;
  }

   /**
   * The contents of the message to send to the conversation. 
   * @return message
  **/
  @ApiModelProperty(value = "The contents of the message to send to the conversation. ")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnvelopeMethodSendMessage envelopeMethodSendMessage = (EnvelopeMethodSendMessage) o;
    return Objects.equals(this.conversationId, envelopeMethodSendMessage.conversationId) &&
        Objects.equals(this.message, envelopeMethodSendMessage.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conversationId, message);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnvelopeMethodSendMessage {\n");
    
    sb.append("    conversationId: ").append(toIndentedString(conversationId)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

