import TdEditorSRC.Entities.Player;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PlayerTest {

    @DataProvider(name = "goodCharacterNameProvider")
    public Object[][] createData1() {
        return new Object[][] {
                {"TestCharacterName"},
                {"987654321987654321987654321"},
                {"98765432198 7654321987654321"},
                {"Árvíztűrő tükörfúrógép"},
        };
    }

    @DataProvider (name = "negativeCharacterNameProvider")
    public Object[][] createData2() {
        return new Object[][] {
                {"TestCharacterNameTestCharacterNameTestCharacterNameTestCharacterName"},
        };
    }

    @Test(dataProvider = "goodCharacterNameProvider")
    public void characterNameTestWithGoodNames(String name) throws Exception {
        Player p = new Player(name);
        Assert.assertEquals(p.getName(), name, "name mismatch");

    }

    @Test(dataProvider = "negativeCharacterNameProvider", expectedExceptions = Exception.class)
    public void characterNameTestWithNegativeNames(String name) throws Exception {
        Player p = new Player(name);
    }



}
