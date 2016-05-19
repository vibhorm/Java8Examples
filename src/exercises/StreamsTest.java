package exercises;

import org.fun.office.Employee;
import org.fun.util.PrettyPrint;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamsTest {
	private static Stream<Employee> employeeStream() {return Employee.getEmployees().stream();}
	@Test
	public void test1(){
		List<LocalDate> dateOfJoining = employeeStream()
				.map(Employee::getDateOfJoining)
				.collect(toList());

		PrettyPrint.list(dateOfJoining);
	}
}
