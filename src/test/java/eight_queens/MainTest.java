package eight_queens;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {

  @Test
  public void test() {

    var main = new Main();

    //
    //
    var res = main.test();
    //
    //

    assertThat(res).isNotNull();
    assertThat(res).isEqualTo("OK!");

  }

}
