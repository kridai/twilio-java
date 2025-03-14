/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.verify.v2.service;

import com.twilio.base.Creator;
import com.twilio.converter.Converter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.util.Map;

public class VerificationCreator extends Creator<Verification> {
    private final String pathServiceSid;
    private final String to;
    private final String channel;
    private String customFriendlyName;
    private String customMessage;
    private String sendDigits;
    private String locale;
    private String customCode;
    private String amount;
    private String payee;
    private Map<String, Object> rateLimits;
    private Map<String, Object> channelConfiguration;
    private String appHash;
    private String templateSid;
    private String templateCustomSubstitutions;

    /**
     * Construct a new VerificationCreator.
     *
     * @param pathServiceSid The SID of the verification Service to create the
     *                       resource under
     * @param to The phone number or email to verify
     * @param channel The verification method to use
     */
    public VerificationCreator(final String pathServiceSid,
                               final String to,
                               final String channel) {
        this.pathServiceSid = pathServiceSid;
        this.to = to;
        this.channel = channel;
    }

    /**
     * A custom user defined friendly name that overwrites the existing one in the
     * verification message.
     *
     * @param customFriendlyName A custom user defined friendly name
     * @return this
     */
    public VerificationCreator setCustomFriendlyName(final String customFriendlyName) {
        this.customFriendlyName = customFriendlyName;
        return this;
    }

    /**
     * The text of a custom message to use for the verification..
     *
     * @param customMessage The text of a custom message to use for the verification
     * @return this
     */
    public VerificationCreator setCustomMessage(final String customMessage) {
        this.customMessage = customMessage;
        return this;
    }

    /**
     * The digits to send after a phone call is answered, for example, to dial an
     * extension. For more information, see the Programmable Voice documentation of
     * <a
     * href="https://www.twilio.com/docs/voice/twiml/number#attributes-sendDigits">sendDigits</a>..
     *
     * @param sendDigits The digits to send after a phone call is answered
     * @return this
     */
    public VerificationCreator setSendDigits(final String sendDigits) {
        this.sendDigits = sendDigits;
        return this;
    }

    /**
     * The locale to use for the verification SMS, WhatsApp or call. Can be: `af`,
     * `ar`, `ca`, `cs`, `da`, `de`, `el`, `en`, `en-GB`, `es`, `fi`, `fr`, `he`,
     * `hi`, `hr`, `hu`, `id`, `it`, `ja`, `ko`, `ms`, `nb`, `nl`, `pl`, `pt`,
     * `pr-BR`, `ro`, `ru`, `sv`, `th`, `tl`, `tr`, `vi`, `zh`, `zh-CN`, or
     * `zh-HK.`.
     *
     * @param locale The locale to use for the verification SMS, WhatsApp or call
     * @return this
     */
    public VerificationCreator setLocale(final String locale) {
        this.locale = locale;
        return this;
    }

    /**
     * A pre-generated code to use for verification. The code can be between 4 and
     * 10 characters, inclusive..
     *
     * @param customCode A pre-generated code
     * @return this
     */
    public VerificationCreator setCustomCode(final String customCode) {
        this.customCode = customCode;
        return this;
    }

    /**
     * The amount of the associated PSD2 compliant transaction. Requires the PSD2
     * Service flag enabled..
     *
     * @param amount The amount of the associated PSD2 compliant transaction.
     * @return this
     */
    public VerificationCreator setAmount(final String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * The payee of the associated PSD2 compliant transaction. Requires the PSD2
     * Service flag enabled..
     *
     * @param payee The payee of the associated PSD2 compliant transaction
     * @return this
     */
    public VerificationCreator setPayee(final String payee) {
        this.payee = payee;
        return this;
    }

    /**
     * The custom key-value pairs of Programmable Rate Limits. Keys correspond to
     * `unique_name` fields defined when <a
     * href="https://www.twilio.com/docs/verify/api/service-rate-limits">creating
     * your Rate Limit</a>. Associated value pairs represent values in the request
     * that you are rate limiting on. You may include multiple Rate Limit values in
     * each request..
     *
     * @param rateLimits The custom key-value pairs of Programmable Rate Limits.
     * @return this
     */
    public VerificationCreator setRateLimits(final Map<String, Object> rateLimits) {
        this.rateLimits = rateLimits;
        return this;
    }

    /**
     * <a href="https://www.twilio.com/docs/verify/email">`email`</a> channel
     * configuration in json format. The fields 'from' and 'from_name' are optional
     * but if included the 'from' field must have a valid email address..
     *
     * @param channelConfiguration Channel specific configuration in json format.
     * @return this
     */
    public VerificationCreator setChannelConfiguration(final Map<String, Object> channelConfiguration) {
        this.channelConfiguration = channelConfiguration;
        return this;
    }

    /**
     * Your <a
     * href="https://developers.google.com/identity/sms-retriever/verify#computing_your_apps_hash_string">App
     * Hash</a> to be appended at the end of your verification SMS body. Applies
     * only to SMS. Example SMS body: `&lt;#&gt; Your AppName verification code is:
     * 1234 He42w354ol9`..
     *
     * @param appHash Your App Hash to be appended at the end of an SMS.
     * @return this
     */
    public VerificationCreator setAppHash(final String appHash) {
        this.appHash = appHash;
        return this;
    }

    /**
     * The message <a
     * href="https://www.twilio.com/docs/verify/api/templates">template</a>. If
     * provided, will override the default template for the Service. SMS channel
     * only..
     *
     * @param templateSid The verification template SMS messages.
     * @return this
     */
    public VerificationCreator setTemplateSid(final String templateSid) {
        this.templateSid = templateSid;
        return this;
    }

    /**
     * A stringified JSON object in which the keys are the template's special
     * variables and the values are the variables substitutions..
     *
     * @param templateCustomSubstitutions The values of the special variables
     *                                    declared on the message template.
     * @return this
     */
    public VerificationCreator setTemplateCustomSubstitutions(final String templateCustomSubstitutions) {
        this.templateCustomSubstitutions = templateCustomSubstitutions;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created Verification
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Verification create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.VERIFY.toString(),
            "/v2/Services/" + this.pathServiceSid + "/Verifications"
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Verification creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Verification.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (to != null) {
            request.addPostParam("To", to);
        }

        if (channel != null) {
            request.addPostParam("Channel", channel);
        }

        if (customFriendlyName != null) {
            request.addPostParam("CustomFriendlyName", customFriendlyName);
        }

        if (customMessage != null) {
            request.addPostParam("CustomMessage", customMessage);
        }

        if (sendDigits != null) {
            request.addPostParam("SendDigits", sendDigits);
        }

        if (locale != null) {
            request.addPostParam("Locale", locale);
        }

        if (customCode != null) {
            request.addPostParam("CustomCode", customCode);
        }

        if (amount != null) {
            request.addPostParam("Amount", amount);
        }

        if (payee != null) {
            request.addPostParam("Payee", payee);
        }

        if (rateLimits != null) {
            request.addPostParam("RateLimits", Converter.mapToJson(rateLimits));
        }

        if (channelConfiguration != null) {
            request.addPostParam("ChannelConfiguration", Converter.mapToJson(channelConfiguration));
        }

        if (appHash != null) {
            request.addPostParam("AppHash", appHash);
        }

        if (templateSid != null) {
            request.addPostParam("TemplateSid", templateSid);
        }

        if (templateCustomSubstitutions != null) {
            request.addPostParam("TemplateCustomSubstitutions", templateCustomSubstitutions);
        }
    }
}