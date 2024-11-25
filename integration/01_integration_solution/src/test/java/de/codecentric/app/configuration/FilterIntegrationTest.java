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

// Lösung Bonus.3
@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest
public class FilterIntegrationTest {

    @Autowired
    private DirectChannel filteredInputChannel;

    @Test
    void shouldFilterMessageOut(CapturedOutput capturedOutput) {
        String testPayload = "kurz";
        filteredInputChannel.send(MessageBuilder.withPayload(testPayload).build());
        assertThat(capturedOutput.getOut()).doesNotContain("Processed message: KURZ");
    }

    @Test
    void shouldTransformAndPassThroughFilter(CapturedOutput capturedOutput) {
        String testPayload = "hello world";
        filteredInputChannel.send(MessageBuilder.withPayload(testPayload).build());
        assertThat(capturedOutput.getOut()).contains("Processed message: HELLO WORLD");
    }
}
