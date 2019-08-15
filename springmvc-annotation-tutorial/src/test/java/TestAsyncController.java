import dev.ankang.contrller.AsyncController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class TestAsyncController {
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        AsyncController asyncController = new AsyncController();
        mockMvc = MockMvcBuilders.standaloneSetup(asyncController).build();
    }

    @Test
    public void testAsync() {
        try {
            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/async01"))
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
            int status = mvcResult.getResponse().getStatus();
            System.out.println("请求状态码：" + status);
            String result = mvcResult.getResponse().getContentAsString();
            System.out.println("接口返回结果：" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
