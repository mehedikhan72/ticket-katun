package com.hy.ticketkatun.train.dto;

import java.time.OffsetDateTime;

public record TrainResponse(String id, String name, String source, String destination, Integer ticketsRemaining) {
}
