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
                    Arguments.of(new TriangleArea(0, 5, 5)),
                    Arguments.of(new TriangleArea(5, 0, 5)),
                    Arguments.of(new TriangleArea(5, 5, 0)),
                    Arguments.of(new TriangleArea(-1, 5, 5)),
                    Arguments.of(new TriangleArea(0, -1, 0)),
                    Arguments.of(new TriangleArea(0, 5, -1)),
                    Arguments.of(new TriangleArea(56, 5, 5))
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
                    Arguments.of(new TriangleArea(1, 1, 1), 0.4330127018922193),
                    Arguments.of(new TriangleArea(25, 20, 6), 36.97887910686315)
            );
        }
        }
    }
}
