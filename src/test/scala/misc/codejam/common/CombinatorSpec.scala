package misc.codejam.common
import org.scalatest.Spec
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class CombinatorSpec extends Spec {
  describe("조합(Combinator) 관련 테스트") {
    it("크기가 5인 숫자 조합에 대한 경우의 수 확인") {
      assert(Combinator(3, List(1,2,3,4,5)).size == 10);
      assert(Combinator(2, List(1,2,3,4,5)).size == 10);
      assert(Combinator(1, List(1,2,3,4,5)).size == 5);
    }
    it("크기가 15인 숫자 조합에 대한 경우의 수 확인") {
      assert(Combinator(4, List(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)).size == 1365);
      assert(Combinator(3, List(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)).size == 455);
      assert(Combinator(2, List(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)).size == 105);
    }
    it("주어진 목록의 크기보다 더 큰 수의 조합은 실패함") {
      val thrown = intercept[IllegalArgumentException]{Combinator(7, List(1,2,3,4,5))};
      assert(thrown.getMessage() == "requirement failed")
    }
    it("0개 이하의 조합은 실패함") {
      val thrown1 = intercept[IllegalArgumentException]{Combinator(0, List(1,2,3,4,5))};
      assert(thrown1.getMessage() == "requirement failed")
      val thrown2 = intercept[IllegalArgumentException]{Combinator(-1, List(1,2))};
      assert(thrown2.getMessage() == "requirement failed")
    }
  }

}