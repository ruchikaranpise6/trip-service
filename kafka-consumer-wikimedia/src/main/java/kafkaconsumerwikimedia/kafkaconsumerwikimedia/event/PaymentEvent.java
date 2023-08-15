package kafkaconsumerwikimedia.kafkaconsumerwikimedia.event;

import kafkaconsumerwikimedia.kafkaconsumerwikimedia.dto.PaymentRequestDto;
import kafkaconsumerwikimedia.kafkaconsumerwikimedia.enums.PaymentStatus;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
public class PaymentEvent implements Event {

    private UUID eventId = UUID.randomUUID();
    private Date date = new Date();
    private PaymentRequestDto paymentRequestDto;
    private PaymentStatus paymentStatus;

    @Override
    public UUID getEventId() {
        return null;
    }

    @Override
    public Date getDate() {
        return null;
    }

    public PaymentEvent(PaymentRequestDto paymentRequestDto, PaymentStatus paymentStatus) {
        this.paymentRequestDto = paymentRequestDto;
        this.paymentStatus = paymentStatus;
    }
}
