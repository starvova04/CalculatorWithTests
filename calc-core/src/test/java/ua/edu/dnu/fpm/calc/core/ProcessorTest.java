package ua.edu.dnu.fpm.calc.core;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;


public class ProcessorTest {

    @Test
    void shouldCallConsumerWithProducedValue() {
        // GIVEN
        Producer producer = mock(Producer.class);
        Consumer consumer = mock(Consumer.class);
        Processor processor = new Processor();
        processor.setProducer(producer);
        processor.setConsumer(consumer);
        when(producer.produce()).thenReturn("Test Value");

        // WHEN
        processor.process();

        // THEN
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(consumer).consume(captor.capture());
        assertThat(captor.getValue(), is("Test Value"));
    }

    @Test
    void shouldThrowExceptionWhenProducerReturnsNull() {
        // GIVEN
        Producer producer = mock(Producer.class);
        Consumer consumer = mock(Consumer.class);
        Processor processor = new Processor();
        processor.setProducer(producer);
        processor.setConsumer(consumer);
        when(producer.produce()).thenReturn(null);

        // WHEN & THEN
        assertThrows(IllegalStateException.class, processor::process);
    }
}
