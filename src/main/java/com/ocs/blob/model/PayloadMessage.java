package com.ocs.blob.model;

import com.ocs.blob.validate.constraints.ValidDate;
import com.ocs.blob.validate.filter.Create;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME;

@Data
public class PayloadMessage {

    @NotBlank(message = "txid cannot be empty")
    private String txId;

    @NotBlank(message = "amount cannot be empty")
    private String amount;

    @Valid
    private String participantId;

    @ValidDate(groups = Create.class, allowedYearsFuture = 2, allowedYearsPast = 2)
    @DateTimeFormat(iso = DATE_TIME)
    private LocalDateTime dateTime;
}
