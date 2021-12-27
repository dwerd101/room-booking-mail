package ru.roombooking.mail.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.roombooking.mail.model.dto.MailRequest;
import ru.roombooking.mail.model.dto.PreviousAndCurrentRecordTableDTO;
import ru.roombooking.mail.model.dto.RecordTableDTO;
import ru.roombooking.mail.response.SuccessResponse;
import ru.roombooking.mail.service.mail.impl.NotificationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mail")
public class MailController {
    private final NotificationService notificationService;

    // FIXME: 16.12.2021 Изменены url с "send" на "send-confirmation"
    @PostMapping("/send-confirmation/{roomId}")
    public ResponseEntity<SuccessResponse> sendConfirmMessageToEmployee(@RequestBody RecordTableDTO recordTableDTO,
                                                                        @PathVariable String roomId) {
        return ResponseEntity.ok(notificationService.sendConfirmMessageToEmployee(recordTableDTO, roomId));

    }

    @PostMapping("/send-confirmation/")
    public ResponseEntity<SuccessResponse> sendConfirmUpdateMessageToEmployee(@RequestBody PreviousAndCurrentRecordTableDTO previousAndCurrentRecordTableDTO) {
        return ResponseEntity.ok(notificationService
                .sendConfirmUpdateMessageToEmployee(previousAndCurrentRecordTableDTO.getPrevious(),
                        previousAndCurrentRecordTableDTO.getCurrent()));
    }

    @PostMapping("/delete-confirmation/")
    public ResponseEntity<SuccessResponse> sendConfirmDeleteMessageToEmployee(@RequestBody RecordTableDTO recordTableDTO) {
        return ResponseEntity.ok(notificationService.sendConfirmDeleteMessageToEmployee(recordTableDTO));
    }

    @PostMapping("/send")
    public ResponseEntity<SuccessResponse> send (@RequestBody MailRequest mailRequest) {
        return ResponseEntity.ok(notificationService.send(mailRequest));
    }
}
