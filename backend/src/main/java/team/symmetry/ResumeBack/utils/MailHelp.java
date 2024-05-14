package team.symmetry.ResumeBack.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import team.symmetry.ResumeBack.dto.CorpRegister.CorpRegisterDTO;
import team.symmetry.ResumeBack.services.EmailService;

@Service
public class MailHelp {
    @Value("${app.corprequests.address}")
    public String corpRequestsAddress;

    @Autowired
    EmailService emailService;

    public void sendReqMail(CorpRegisterDTO dto) {
        emailService.sendSimpleEmail(corpRequestsAddress, dto.getName(),
                "Организация " + dto.getUrName() + "отправила заявку на получение доступа к сервису Резюме" +
                        "Контактные данные: \n" +
                        "Телефон: " + dto.getPhone() + '\n' +
                        "Почта: " + dto.getEmail() + '\n');
    }
}
