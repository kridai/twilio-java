/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.verify.v2.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.Converter;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Verification extends Resource {
    private static final long serialVersionUID = 216517595769072L;

    public enum Channel {
        SMS("sms"),
        CALL("call"),
        EMAIL("email"),
        WHATSAPP("whatsapp"),
        SILENT("silent");

        private final String value;

        private Channel(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Channel from a string.
         * @param value string value
         * @return generated Channel
         */
        @JsonCreator
        public static Channel forValue(final String value) {
            return Promoter.enumFromString(value, Channel.values());
        }
    }

    public enum Status {
        CANCELED("canceled"),
        APPROVED("approved");

        private final String value;

        private Status(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Status from a string.
         * @param value string value
         * @return generated Status
         */
        @JsonCreator
        public static Status forValue(final String value) {
            return Promoter.enumFromString(value, Status.values());
        }
    }

    /**
     * Create a VerificationCreator to execute create.
     *
     * @param pathServiceSid The SID of the verification Service to create the
     *                       resource under
     * @param to The phone number or email to verify
     * @param channel The verification method to use
     * @return VerificationCreator capable of executing the create
     */
    public static VerificationCreator creator(final String pathServiceSid,
                                              final String to,
                                              final String channel) {
        return new VerificationCreator(pathServiceSid, to, channel);
    }

    /**
     * Create a VerificationUpdater to execute update.
     *
     * @param pathServiceSid The SID of the verification Service to update the
     *                       resource from
     * @param pathSid The unique string that identifies the resource
     * @param status The new status of the resource
     * @return VerificationUpdater capable of executing the update
     */
    public static VerificationUpdater updater(final String pathServiceSid,
                                              final String pathSid,
                                              final Verification.Status status) {
        return new VerificationUpdater(pathServiceSid, pathSid, status);
    }

    /**
     * Create a VerificationFetcher to execute fetch.
     *
     * @param pathServiceSid The SID of the verification Service to fetch the
     *                       resource from
     * @param pathSid The unique string that identifies the resource
     * @return VerificationFetcher capable of executing the fetch
     */
    public static VerificationFetcher fetcher(final String pathServiceSid,
                                              final String pathSid) {
        return new VerificationFetcher(pathServiceSid, pathSid);
    }

    /**
     * Converts a JSON String into a Verification object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Verification object represented by the provided JSON
     */
    public static Verification fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Verification.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Verification object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Verification object represented by the provided JSON
     */
    public static Verification fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Verification.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String serviceSid;
    private final String accountSid;
    private final String to;
    private final Verification.Channel channel;
    private final String status;
    private final Boolean valid;
    private final Map<String, Object> lookup;
    private final String amount;
    private final String payee;
    private final List<Map<String, Object>> sendCodeAttempts;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final URI url;

    @JsonCreator
    private Verification(@JsonProperty("sid")
                         final String sid,
                         @JsonProperty("service_sid")
                         final String serviceSid,
                         @JsonProperty("account_sid")
                         final String accountSid,
                         @JsonProperty("to")
                         final String to,
                         @JsonProperty("channel")
                         final Verification.Channel channel,
                         @JsonProperty("status")
                         final String status,
                         @JsonProperty("valid")
                         final Boolean valid,
                         @JsonProperty("lookup")
                         final Map<String, Object> lookup,
                         @JsonProperty("amount")
                         final String amount,
                         @JsonProperty("payee")
                         final String payee,
                         @JsonProperty("send_code_attempts")
                         final List<Map<String, Object>> sendCodeAttempts,
                         @JsonProperty("date_created")
                         final String dateCreated,
                         @JsonProperty("date_updated")
                         final String dateUpdated,
                         @JsonProperty("url")
                         final URI url) {
        this.sid = sid;
        this.serviceSid = serviceSid;
        this.accountSid = accountSid;
        this.to = to;
        this.channel = channel;
        this.status = status;
        this.valid = valid;
        this.lookup = lookup;
        this.amount = amount;
        this.payee = payee;
        this.sendCodeAttempts = sendCodeAttempts;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
    }

    /**
     * Returns The unique string that identifies the resource.
     *
     * @return The unique string that identifies the resource
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The SID of the Service that the resource is associated with.
     *
     * @return The SID of the Service that the resource is associated with
     */
    public final String getServiceSid() {
        return this.serviceSid;
    }

    /**
     * Returns The SID of the Account that created the resource.
     *
     * @return The SID of the Account that created the resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The phone number or email being verified.
     *
     * @return The phone number or email being verified
     */
    public final String getTo() {
        return this.to;
    }

    /**
     * Returns The verification method used..
     *
     * @return The verification method used.
     */
    public final Verification.Channel getChannel() {
        return this.channel;
    }

    /**
     * Returns The status of the verification resource.
     *
     * @return The status of the verification resource
     */
    public final String getStatus() {
        return this.status;
    }

    /**
     * Returns Whether the verification was successful.
     *
     * @return Whether the verification was successful
     */
    public final Boolean getValid() {
        return this.valid;
    }

    /**
     * Returns Information about the phone number being verified.
     *
     * @return Information about the phone number being verified
     */
    public final Map<String, Object> getLookup() {
        return this.lookup;
    }

    /**
     * Returns The amount of the associated PSD2 compliant transaction..
     *
     * @return The amount of the associated PSD2 compliant transaction.
     */
    public final String getAmount() {
        return this.amount;
    }

    /**
     * Returns The payee of the associated PSD2 compliant transaction.
     *
     * @return The payee of the associated PSD2 compliant transaction
     */
    public final String getPayee() {
        return this.payee;
    }

    /**
     * Returns An array of verification attempt objects..
     *
     * @return An array of verification attempt objects.
     */
    public final List<Map<String, Object>> getSendCodeAttempts() {
        return this.sendCodeAttempts;
    }

    /**
     * Returns The RFC 2822 date and time in GMT when the resource was created.
     *
     * @return The RFC 2822 date and time in GMT when the resource was created
     */
    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The RFC 2822 date and time in GMT when the resource was last updated.
     *
     * @return The RFC 2822 date and time in GMT when the resource was last updated
     */
    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The absolute URL of the Verification resource.
     *
     * @return The absolute URL of the Verification resource
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Verification other = (Verification) o;

        return Objects.equals(sid, other.sid) &&
               Objects.equals(serviceSid, other.serviceSid) &&
               Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(to, other.to) &&
               Objects.equals(channel, other.channel) &&
               Objects.equals(status, other.status) &&
               Objects.equals(valid, other.valid) &&
               Objects.equals(lookup, other.lookup) &&
               Objects.equals(amount, other.amount) &&
               Objects.equals(payee, other.payee) &&
               Objects.equals(sendCodeAttempts, other.sendCodeAttempts) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            serviceSid,
                            accountSid,
                            to,
                            channel,
                            status,
                            valid,
                            lookup,
                            amount,
                            payee,
                            sendCodeAttempts,
                            dateCreated,
                            dateUpdated,
                            url);
    }
}