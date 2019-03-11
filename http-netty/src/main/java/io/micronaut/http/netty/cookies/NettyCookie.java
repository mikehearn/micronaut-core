/*
 * Copyright 2017-2019 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.http.netty.cookies;

import io.micronaut.core.annotation.Internal;
import io.micronaut.http.cookie.Cookie;
import io.netty.handler.codec.http.cookie.DefaultCookie;

import javax.annotation.Nonnull;
import java.util.Objects;

/**
 * A wrapper around a Netty cookie.
 *
 * @author Graeme Rocher
 * @since 1.0
 */
@Internal
public class NettyCookie implements Cookie {

    private final io.netty.handler.codec.http.cookie.Cookie nettyCookie;

    /**
     * @param nettyCookie The Netty cookie
     */
    public NettyCookie(io.netty.handler.codec.http.cookie.Cookie nettyCookie) {
        this.nettyCookie = nettyCookie;
    }

    /**
     * @param name  The name
     * @param value The value
     */
    public NettyCookie(String name, String value) {
        Objects.requireNonNull(name, "Argument name cannot be null");
        Objects.requireNonNull(value, "Argument value cannot be null");

        this.nettyCookie = new DefaultCookie(name, value);
    }

    /**
     * @return The Netty cookie
     */
    public io.netty.handler.codec.http.cookie.Cookie getNettyCookie() {
        return nettyCookie;
    }

    @Override
    public @Nonnull String getName() {
        return nettyCookie.name();
    }

    @Override
    public @Nonnull String getValue() {
        return nettyCookie.value();
    }

    @Override
    public String getDomain() {
        return nettyCookie.domain();
    }

    @Override
    public String getPath() {
        return nettyCookie.path();
    }

    @Override
    public boolean isHttpOnly() {
        return nettyCookie.isHttpOnly();
    }

    @Override
    public boolean isSecure() {
        return nettyCookie.isSecure();
    }

    @Override
    public long getMaxAge() {
        return nettyCookie.maxAge();
    }

    @Override
    public @Nonnull Cookie maxAge(long maxAge) {
        nettyCookie.setMaxAge(maxAge);
        return this;
    }

    @Override
    public @Nonnull Cookie value(@Nonnull String value) {
        nettyCookie.setValue(value);
        return this;
    }

    @Override
    public @Nonnull Cookie domain(String domain) {
        nettyCookie.setDomain(domain);
        return this;
    }

    @Override
    public @Nonnull Cookie path(String path) {
        nettyCookie.setPath(path);
        return this;
    }

    @Override
    public @Nonnull Cookie secure(boolean secure) {
        nettyCookie.setSecure(secure);
        return this;
    }

    @Override
    public @Nonnull Cookie httpOnly(boolean httpOnly) {
        nettyCookie.setHttpOnly(httpOnly);
        return this;
    }

    @Override
    public int compareTo(Cookie o) {
        NettyCookie nettyCookie = (NettyCookie) o;
        return nettyCookie.nettyCookie.compareTo(this.nettyCookie);
    }
}
