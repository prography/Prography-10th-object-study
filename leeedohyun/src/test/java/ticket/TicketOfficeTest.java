package ticket;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TicketOfficeTest {

    @Test
    void 티켓을_판매한다() {
        // given
        Ticket ticket = new Ticket(100L);
        TicketOffice ticketOffice = new TicketOffice(1000L, ticket);
        Audience audience = new Audience(new Bag(1000L));

        // when
        ticketOffice.sellTicketTo(audience);

        // then
        assertThat(ticketOffice.getAmount()).isEqualTo(1100L);
    }
}
