package com.example.lab04;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Route("index1")
public class MathView extends VerticalLayout {
    private TextField number1Field, number2Field, answerField;
    private Button addBtn, subBtn, mulBtn, divBtn, modBtn, maxBtn;
    private HorizontalLayout buttonLayout;
    private Paragraph btnLabel;

    public MathView() {
        number1Field = new TextField("Number 1");
        number2Field = new TextField("Number 2");
        answerField = new TextField("Answer");
        addBtn = new Button("+");
        addBtn.getStyle().set("cursor", "pointer");
        addBtn.addClickListener(e -> {
            double a = Double.parseDouble(number1Field.getValue());
            double b = Double.parseDouble(number2Field.getValue());

            String v = WebClient
                .create()
                .get()
                .uri("http://localhost:8080/plus/" + a + "/" + b)
                .retrieve()
                .bodyToMono(String.class)
                .block();

            answerField.setValue(v);
        });
        subBtn = new Button("-");
        subBtn.getStyle().set("cursor", "pointer");
        subBtn.addClickListener(e -> {
            double a = Double.parseDouble(number1Field.getValue());
            double b = Double.parseDouble(number2Field.getValue());

            String v = WebClient
                    .create()
                    .get()
                    .uri("http://localhost:8080/minus/" + a + "/" + b)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            answerField.setValue(v);
        });
        mulBtn = new Button("x");
        mulBtn.getStyle().set("cursor", "pointer");
        mulBtn.addClickListener(e -> {
            double a = Double.parseDouble(number1Field.getValue());
            double b = Double.parseDouble(number2Field.getValue());

            String v = WebClient
                    .create()
                    .get()
                    .uri("http://localhost:8080/multi/" + a + "/" + b)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            answerField.setValue(v);
        });
        divBtn = new Button("/");
        divBtn.getStyle().set("cursor", "pointer");
        divBtn.addClickListener(e -> {
            double a = Double.parseDouble(number1Field.getValue());
            double b = Double.parseDouble(number2Field.getValue());

            String v = WebClient
                    .create()
                    .get()
                    .uri("http://localhost:8080/divide/" + a + "/" + b)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            answerField.setValue(v);
        });
        modBtn = new Button("mod");
        modBtn.getStyle().set("cursor", "pointer");
        modBtn.addClickListener(e -> {
            double a = Double.parseDouble(number1Field.getValue());
            double b = Double.parseDouble(number2Field.getValue());

            String v = WebClient
                    .create()
                    .get()
                    .uri("http://localhost:8080/mod/" + a + "/" + b)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            answerField.setValue(v);
        });
        maxBtn = new Button("max");
        maxBtn.getStyle().set("cursor", "pointer");
        maxBtn.addClickListener(e -> {
            double a = Double.parseDouble(number1Field.getValue());
            double b = Double.parseDouble(number2Field.getValue());

            String v = WebClient
                    .create()
                    .post()
                    .uri("http://localhost:8080/max")
                    .body(Mono.just(new MaxRequest(a, b)), MaxRequest.class)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            answerField.setValue(v);
        });
        buttonLayout = new HorizontalLayout();
        buttonLayout.add(addBtn, subBtn, mulBtn, divBtn, modBtn, maxBtn);
        btnLabel = new Paragraph("Operator");
        btnLabel.getStyle().set("margin", "0px");

        this.add(number1Field, number2Field, btnLabel, buttonLayout, answerField);
    }
}
