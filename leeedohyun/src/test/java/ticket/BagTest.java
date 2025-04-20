package ticket;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BagTest {

    @Test
    void 초대쟝을_갸지고_있으면_무료로_티켓을_교환한다() {
        // given
        Bag bag = new Bag(new Invitation(), 1000L);

        // when
        Long fee = bag.hold(new Ticket(1000L));

        // then
        assertThat(fee).isZero();
    }

    @Test
    void 초대장을_가지고_있지_않으면_티켓을_구매해야_한다() {
        // given
        Bag bag = new Bag(1000L);

        // when
        Long fee = bag.hold(new Ticket(1000L));

        // then
        assertThat(fee).isEqualTo(1000L);
        assertThat(bag.getAmount()).isEqualTo(0L);
    }
}
