package demo.pavel.recipe.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import demo.pavel.recipe.commands.UnitOfMeasureCommand;
import demo.pavel.recipe.model.UnitOfMeasure;

public class UnitOfMeasureCommandToUnitOfMeasureTest {

	public static final String DESCRIPTION = "description";
	public static final Long LONG_VALUE = 1L;

	UnitOfMeasureCommandToUnitOfMeasure converter;

	@Before
	public void setUp() throws Exception {
		converter = new UnitOfMeasureCommandToUnitOfMeasure();

	}

	@Test
	public void testNullParamter() throws Exception {
		assertNull(converter.convert(null));
	}

	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(converter.convert(new UnitOfMeasureCommand()));
	}

	@Test
	public void convert() throws Exception {
		//given
		UnitOfMeasureCommand command = new UnitOfMeasureCommand();
		command.setId(LONG_VALUE);
		command.setDescription(DESCRIPTION);

		//when
		UnitOfMeasure uom = converter.convert(command);

		//then
		assertNotNull(uom);
		assertEquals(LONG_VALUE, uom.getId());
		assertEquals(DESCRIPTION, uom.getDescription());

	}

}
