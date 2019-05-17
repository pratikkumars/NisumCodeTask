package zipProblem;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZipProblemTest {

	//unsorted zip ranges which not share any comman zip codes
	@Test
	public void testOptimizingZipRages1() {
		ZipProblem z = new ZipProblem();
		String inputZipRanges ="[56894,56985][45123,45236][98523,99541][35968,35999]";
		String expectedOutputZipRange="[35968,35999][45123,45236][56894,56985][98523,99541]";
		String outputZipRanges = z.optimizingZipRages(inputZipRanges);
		assertEquals(expectedOutputZipRange, outputZipRanges);
	}
	
	//unsorted zip ranges which shares some zipcode common
		@Test
		public void testOptimizingZipRages2() {
			ZipProblem z = new ZipProblem();
			String inputZipRanges ="[56894,56985][45123,45236][98523,99541][35968,45210]";
			String expectedOutputZipRange="[35968,45236][56894,56985][98523,99541]";
			String outputZipRanges = z.optimizingZipRages(inputZipRanges);
			assertEquals(expectedOutputZipRange, outputZipRanges);
		}
		
		//unsorted zip ranges which share any comman zip codes as well as whole range is merged in other
		@Test
		public void testOptimizingZipRages3() {
			ZipProblem z = new ZipProblem();
			String inputZipRanges ="[56894,56985][45123,45236][98523,99541][35968,45210][98865,99258]";
			String expectedOutputZipRange="[35968,45236][56894,56985][98523,99541]";
			String outputZipRanges = z.optimizingZipRages(inputZipRanges);
			assertEquals(expectedOutputZipRange, outputZipRanges);
		}		
		//unsorted zip ranges which share any comman zip codes as well as whole range is merged in other
		@Test
		public void testOptimizingZipRages4() {
			ZipProblem z = new ZipProblem();
			String inputZipRanges ="[56894,56985][45123,45236][98523,99541][35968,45210][98865,99258][44526,49865]";
			String expectedOutputZipRange="[35968,49865][56894,56985][98523,99541]";
			String outputZipRanges = z.optimizingZipRages(inputZipRanges);
			assertEquals(expectedOutputZipRange, outputZipRanges);
		}	
}
