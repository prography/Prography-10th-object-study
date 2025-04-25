package ticket;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AudienceTest {

    @Test
    void 티켓을_구매한다() {
        // given
        Ticket ticket = new Ticket(100L);
        Audience audience = new Audience(new Bag(100L));

        // when
        Long fee = audience.buy(ticket);

        // then
        assertThat(fee).isEqualTo(ticket.getFee());
        assertThat(audience.getBag().hasTicket()).isTrue();
        assertThat(audience.getBag().getAmount()).isZero();
    }
}
