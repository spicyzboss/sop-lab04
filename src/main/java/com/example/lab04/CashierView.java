package com.example.lab04;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;

@Route("index2")
public class CashierView extends VerticalLayout {
    private TextField changeField, b1000Field, b500Field, b100Field, b20Field, b10Field, b5Field, b1Field;
    private Button changeBtn;

    public CashierView() {
        changeField = new TextField("เงินทอน");
        b1000Field = new TextField();
        b1000Field.setPrefixComponent(new Paragraph("$1000:"));
        b500Field = new TextField();
        b500Field.setPrefixComponent(new Paragraph("$500:"));
        b100Field = new TextField();
        b100Field.setPrefixComponent(new Paragraph("$100:"));
        b20Field = new TextField();
        b20Field.setPrefixComponent(new Paragraph("$20:"));
        b10Field = new TextField();
        b10Field.setPrefixComponent(new Paragraph("$10:"));
        b5Field = new TextField();
        b5Field.setPrefixComponent(new Paragraph("$5:"));
        b1Field = new TextField();
        b1Field.setPrefixComponent(new Paragraph("$1:"));
        changeBtn = new Button("คำนวณเงินทอน");
        changeBtn.getStyle().set("color", "blue");
        changeBtn.getStyle().set("cursor", "pointer");
        changeBtn.addClickListener(e -> {
            Change result = WebClient
                    .create()
                    .get()
                    .uri("http://localhost:8080/getChange/" + changeField.getValue())
                    .retrieve()
                    .bodyToMono(Change.class)
                    .block();

            b1000Field.setValue(result.getB1000() + "");
            b500Field.setValue(result.getB500() + "");
            b100Field.setValue(result.getB100() + "");
            b20Field.setValue(result.getB20() + "");
            b10Field.setValue(result.getB10() + "");
            b5Field.setValue(result.getB5() + "");
            b1Field.setValue(result.getB1() + "");
        });
        this.add(changeField, changeBtn, b1000Field, b500Field, b100Field, b20Field, b10Field, b5Field, b1Field);
    }
}
