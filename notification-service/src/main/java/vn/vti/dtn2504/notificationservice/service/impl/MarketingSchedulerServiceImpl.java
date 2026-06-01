package vn.vti.dtn2504.notificationservice.service.impl;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import vn.vti.dtn2504.notificationservice.client.UserManagerClient;
import vn.vti.dtn2504.notificationservice.client.dto.User;
import vn.vti.dtn2504.notificationservice.entity.EmailDetails;
import vn.vti.dtn2504.notificationservice.service.EmailService;
import vn.vti.dtn2504.notificationservice.service.MarketingSchedulerService;

@Service
@RequiredArgsConstructor
public class MarketingSchedulerServiceImpl implements MarketingSchedulerService {

    private final UserManagerClient userManagerClient;
    private final EmailService emailService;

    @Override
    @Scheduled(cron = "0 0 12 1 1/1 *")
    public void sendBlackFridayPromotionEmail() {
        List<User> users = userManagerClient.findAllUsers();
        for (User user : users) {
            if (!StringUtils.hasText(user.getEmail())) {
                continue;
            }
            EmailDetails emailDetails = new EmailDetails();
            emailDetails.setRecipient(user.getEmail());
            emailService.sendSimpleMailInBlackFriday(emailDetails);
        }
    }
}
