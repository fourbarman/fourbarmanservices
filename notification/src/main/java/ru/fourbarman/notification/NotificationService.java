package ru.fourbarman.notification;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fourbarman.clients.notification.NotificationRequest;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.customerId())
                        .toCustomerEmail(notificationRequest.customerEmail())
                        .sender("Example sender")
                        .message(notificationRequest.message())
                        .sent_at(LocalDateTime.now())
                        .build()
        );
    }
}
