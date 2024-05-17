package com.learning.cartservice.exception;

import java.time.ZonedDateTime;

public record ApiExceptionFormat(String message, ZonedDateTime zonedDateTime) {
}
