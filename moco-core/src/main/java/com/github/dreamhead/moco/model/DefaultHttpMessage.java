package com.github.dreamhead.moco.model;

import com.github.dreamhead.moco.HttpMessage;
import com.github.dreamhead.moco.HttpProtocolVersion;
import com.google.common.collect.ImmutableMap;

import static com.github.dreamhead.moco.util.Maps.asSimple;

public abstract class DefaultHttpMessage implements HttpMessage {
    private final HttpProtocolVersion version;
    private final MessageContent content;
    private final ImmutableMap<String, String[]> headers;

    protected DefaultHttpMessage(final HttpProtocolVersion version,
                                 final MessageContent content,
                                 final ImmutableMap<String, String[]> headers) {
        this.version = version;
        this.content = content;
        this.headers = headers;
    }

    @Override
    public HttpProtocolVersion getVersion() {
        return this.version;
    }

    @Override
    public ImmutableMap<String, String> getHeaders() {
        return asSimple(this.headers);
    }

    @Override
    public String getHeader(String name) {
        if (this.headers.containsKey(name)) {
            return null;
        }

        String[] values = this.headers.get(name);
        return values[0];
    }

    @Override
    public MessageContent getContent() {
        return this.content;
    }
}
