package fr.okteo.formcreatorback.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * ResponseModel
 */

public class ResponseModel {
    /**
     * Corps de la réponse
     */
    @JsonProperty("body")
    private Object body;

    /**
     * Métadonnées
     */
    @JsonProperty("metadata")
    private Object metadata;

    /**
     * Indicateur de réussite de l'appel au WS
     */
    @JsonProperty("successful")
    private Boolean successful;

    /**
     * Message d'erreur (renseigné lorsque successful = false)
     */
    @JsonProperty("message")
    private String message;

    public ResponseModel body(Object body) {
        this.body = body;
        return this;
    }

    public ResponseModel metadata(Object metadata) {
        this.metadata = metadata;
        return this;
    }

    public ResponseModel successful(Boolean successful) {
        this.successful = successful;
        return this;
    }

    public ResponseModel message(String message) {
        this.message = message;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResponseModel responseModel = (ResponseModel) o;
        return Objects.equals(this.body, responseModel.body) &&
                Objects.equals(this.successful, responseModel.successful) &&
                Objects.equals(this.message, responseModel.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(body, successful, message);
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public Object getMetadata() {
        return metadata;
    }

    public void setMetadata(Object metadata) {
        this.metadata = metadata;
    }

    public Boolean getSuccessful() {
        return successful;
    }

    public void setSuccessful(Boolean successful) {
        this.successful = successful;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResponseModel {\n");

        sb.append("    body: ").append(toIndentedString(body)).append("\n");
        sb.append("    successful: ").append(toIndentedString(successful)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}