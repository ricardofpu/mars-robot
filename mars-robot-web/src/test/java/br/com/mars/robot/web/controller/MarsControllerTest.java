package br.com.mars.robot.web.controller;

import br.com.mars.robot.web.ControllerBaseTest;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MarsControllerTest extends ControllerBaseTest {

    private static final String COMMAND_PATH_VARIABLE = "Identify a command received in request. Commands valid are L (left), R (right) and M (move)";

    @Test
    public void robotCommandSuccess() throws Exception {
        String command = "MM";
        this.mockMvc.perform(post("/rest/mars/{commands}", command)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string("0, 2, N"))
                .andDo(
                        documentationResultHandler.document(
                                pathParameters(
                                        parameterWithName("commands").description(COMMAND_PATH_VARIABLE)
                                )
                        )
                );
    }

    @Test
    public void robotCommandMoveToRightSuccess() throws Exception {
        String command = "MMRMMRMM";
        this.mockMvc.perform(post("/rest/mars/{commands}", command)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string("2, 0, S"))
                .andDo(
                        documentationResultHandler.document(
                                pathParameters(
                                        parameterWithName("commands").description(COMMAND_PATH_VARIABLE)
                                )
                        )
                );
    }

    @Test
    public void robotCommandMoveToLeftSuccess() throws Exception {
        String command = "MML";
        this.mockMvc.perform(post("/rest/mars/{commands}", command)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string("0, 2, W"))
                .andDo(
                        documentationResultHandler.document(
                                pathParameters(
                                        parameterWithName("commands").description(COMMAND_PATH_VARIABLE)
                                )
                        )
                );
    }

    @Test
    public void failRobotCommandInvalid() throws Exception {
        String command = "AAA";
        this.mockMvc.perform(post("/rest/mars/{commands}", command)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isBadRequest())
                .andDo(
                        documentationResultHandler.document(
                                pathParameters(
                                        parameterWithName("commands").description(COMMAND_PATH_VARIABLE)
                                )
                        )
                );
    }

    @Test
    public void failRobotCommandInvalidPosition() throws Exception {
        String command = "MMMMMMMMMMMMMMMMMMMMMMMM";
        this.mockMvc.perform(post("/rest/mars/{commands}", command)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isBadRequest())
                .andDo(
                        documentationResultHandler.document(
                                pathParameters(
                                        parameterWithName("commands").description(COMMAND_PATH_VARIABLE)
                                )
                        )
                );
    }

}
