package com.general.sightly.components;

import com.general.sightly.bean.HelloTextBean;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Shashi Bhushan
 *         Created on 9/5/16.
 *         For Project : sightly
 */
@RunWith(MockitoJUnitRunner.class)
public class HelloTextComponentTest {

    @Mock
    private HelloTextComponent helloTextComponent;

    @Mock
    private HelloTextBean helloTextBean;

    @Before
    public void setup(){
        helloTextComponent = mock(HelloTextComponent.class);
        helloTextBean = new HelloTextBean();

        helloTextBean.setHeadingText("Heading Title");
        helloTextBean.setDescription("Description");

        when(helloTextComponent.getHelloTextBean()).thenReturn(helloTextBean);
    }

    @Test
    public void getTitle(){
        System.out.println("Mock : " + helloTextComponent.getHelloTextBean());
        System.out.println("Mock : " + helloTextComponent.getHelloTextBean().getHeadingText());
    }
}
