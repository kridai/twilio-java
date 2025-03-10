/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.media.v1.playerstreamer;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class PlaybackGrantCreator extends Creator<PlaybackGrant> {
    private final String pathSid;
    private Integer ttl;
    private String accessControlAllowOrigin;

    /**
     * Construct a new PlaybackGrantCreator.
     *
     * @param pathSid The unique string that identifies the PlayerStreamer
     *                associated with this PlaybackGrant.
     */
    public PlaybackGrantCreator(final String pathSid) {
        this.pathSid = pathSid;
    }

    /**
     * The time to live of the PlaybackGrant. Default value is 15 seconds. Maximum
     * value is 60 seconds..
     *
     * @param ttl The time to live of the PlaybackGrant
     * @return this
     */
    public PlaybackGrantCreator setTtl(final Integer ttl) {
        this.ttl = ttl;
        return this;
    }

    /**
     * The full origin URL where the livestream can be streamed. If this is not
     * provided, it can be streamed from any domain..
     *
     * @param accessControlAllowOrigin The full URL that is authorized to play back
     *                                 the livestream
     * @return this
     */
    public PlaybackGrantCreator setAccessControlAllowOrigin(final String accessControlAllowOrigin) {
        this.accessControlAllowOrigin = accessControlAllowOrigin;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created PlaybackGrant
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public PlaybackGrant create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.MEDIA.toString(),
            "/v1/PlayerStreamers/" + this.pathSid + "/PlaybackGrant"
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("PlaybackGrant creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return PlaybackGrant.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (ttl != null) {
            request.addPostParam("Ttl", ttl.toString());
        }

        if (accessControlAllowOrigin != null) {
            request.addPostParam("AccessControlAllowOrigin", accessControlAllowOrigin);
        }
    }
}