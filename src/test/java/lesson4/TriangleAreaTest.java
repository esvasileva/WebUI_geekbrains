package lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TriangleAreaTest {

    @Nested
    class WhenIncorrectTriangle {
        @ParameterizedTest
        @MethodSource("triangleIncorrectDataProvider")
        void calcTriangleIncorrectAreaTest(TriangleArea triangleArea) {
            Assertions.assertThrows(NonExistentTriangle.class, () -> triangleArea.calcTriangleArea());
        }

        private static Stream<Arguments> triangleIncorrectDataProvider() {
            return Stream.of(
                    Arguments.of(new TriangleArea(2, 5, 0)),
                    Arguments.of(new TriangleArea(2, 5, 180)),
                    Arguments.of(new TriangleArea(2, 5, -1)),
                    Arguments.of(new TriangleArea(2, 5, 181)),
                    Arguments.of(new TriangleArea(0, 5, 90)),
                    Arguments.of(new TriangleArea(-0.1, 5, 90)),
                    Arguments.of(new TriangleArea(2, 0, 90)),
                    Arguments.of(new TriangleArea(2, -0.1, 90))
            );
        }

    @Nested
    class WhenCorrectTriangle {
        @ParameterizedTest
        @MethodSource("triangleDataProvider")
        void calcTriangleAreaTest(TriangleArea triangleArea, double result) throws NonExistentTriangle {
            Assertions.assertEquals(triangleArea.calcTriangleArea(), result);
        }

        private static Stream<Arguments> triangleDataProvider() {
            return Stream.of(
                    Arguments.of(new TriangleArea(2, 5, 90), 5.0),
                    Arguments.of(new TriangleArea(0.1, 0.1, 65), 0.00453153893518325),
                    Arguments.of(new TriangleArea(2, 5, 1), 0.08726203218641757),
                    Arguments.of(new TriangleArea(2, 5, 179), 0.08726203218641719)
            );
        }
        }
    }
}
