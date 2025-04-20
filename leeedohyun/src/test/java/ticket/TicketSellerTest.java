package ticket;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TicketSellerTest {

    @Test
    void 티켓을_판매한다() {
        // given
        Ticket ticket1 = new Ticket(100L);
        Ticket ticket2 = new Ticket(100L);
        Ticket ticket3 = new Ticket(100L);

        TicketOffice ticketOffice = new TicketOffice(100L, ticket1, ticket2, ticket3);

        TicketSeller ticketSeller = new TicketSeller(ticketOffice);

        Audience audience = new Audience(new Bag(100L));

        // when
        ticketSeller.sellTo(audience);

        // then
        assertThat(audience.getBag().hasTicket()).isTrue();
    }
}
