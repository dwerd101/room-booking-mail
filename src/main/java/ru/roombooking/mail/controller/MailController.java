package ru.roombooking.mail.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.roombooking.mail.model.dto.RecordTableDTO;
import ru.roombooking.mail.model.response.SuccessResponse;
import ru.roombooking.mail.service.mail.impl.NotificationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mail")
public class MailController {
    private final NotificationService notificationService;


    @PostMapping("/send/{roomId}")
    public ResponseEntity<SuccessResponse> sendConfirmMessageToEmployee(@RequestBody RecordTableDTO recordTableDTO,
                                                                        @PathVariable String roomId) {
        return ResponseEntity.ok(notificationService.sendConfirmMessageToEmployee(recordTableDTO, roomId));

    }

    @PutMapping("/send/")
    public ResponseEntity<SuccessResponse> sendConfirmUpdateMessageToEmployee(@RequestBody RecordTableDTO previousRecordTableDTO,
                                                                             @RequestBody RecordTableDTO recordTableDTO) {
        return ResponseEntity.ok(notificationService.sendConfirmUpdateMessageToEmployee(previousRecordTableDTO, recordTableDTO));
    }

    @DeleteMapping("/delete/")
    public ResponseEntity<SuccessResponse> sendConfirmDeleteMessageToEmployee(@RequestBody RecordTableDTO recordTableDTO) {
        return ResponseEntity.ok(notificationService.sendConfirmDeleteMessageToEmployee(recordTableDTO));
    }

}
