package Lab2;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
                     
public class test1 {
	lab2 test = new lab2();
	@DisplayName("UnitTest")
	@ParameterizedTest(name = "{index} {0} {1} {2}")
	@MethodSource("parameterDataProvider")
	void testcase(String path,int level,String res) throws IOException {
		assertEquals(res, test.perform(path,level));
	}
	private static Stream<Arguments> parameterDataProvider() {
		return Stream.of(
				Arguments.of("C:\\test\\code.txt",4, "total num: 35\n" + 
						"switch num: 2\n" + 
						"case num: 3 2\n" + 
						"if-else num: 2\n" + 
						"if-elseif-else num: 2\n")
				,Arguments.of("C:\\test\\code.txt",3, "total num: 35\n" + 
						"switch num: 2\n" + 
						"case num: 3 2\n" + 
						"if-else num: 2\n")
				,Arguments.of("C:\\test\\code.txt",2, "total num: 35\n" + 
						"switch num: 2\n" + 
						"case num: 3 2\n" 
						)
				,Arguments.of("C:\\test\\code.txt",1, "total num: 35\n" )
				);
	}
}