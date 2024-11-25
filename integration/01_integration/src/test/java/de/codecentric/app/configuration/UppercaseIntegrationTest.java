package de.codecentric.app.configuration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.support.MessageBuilder;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest
class UppercaseIntegrationTest {

    @Autowired
    private DirectChannel inputChannel;

    @Test
    void shouldTransformToUppercase(CapturedOutput capturedOutput) {

        String testPayload = "hello";
        inputChannel.send(MessageBuilder.withPayload(testPayload).build());

        assertThat(capturedOutput.getOut()).contains("Processed message: HELLO");
    }

}