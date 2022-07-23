package com.example.application.views.ShoppingCart;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin.Horizontal;
import com.vaadin.flow.component.dependency.StyleSheet;


import java.util.ArrayList;
import java.util.HashMap;



@CssImport("./themes/myapp/shopping-cart.css")

@PageTitle("Shopping Cart")//maybe make to name of web
@Route(value = "ShoppingCart", layout = MainLayout.class)

public class ShoppingCartView extends HorizontalLayout{

    String title;
    String image;
    String price;
    String quantity;

    public ShoppingCartView(){

        VaadinSession currentSession = VaadinSession.getCurrent();

        if(currentSession.getAttribute("cart") == null){
            currentSession.setAttribute("cart", new ArrayList<HashMap<String, String>>());
          }

        ArrayList<HashMap<String, String>> cart = (ArrayList<HashMap<String, String>>) currentSession.getAttribute("cart");

        
        // ArrayList<HashMap<String, String>> cart = new ArrayList<HashMap<String, String>>(); 

        // mock data delete later
        // HashMap<String, String> item1 = new HashMap<String, String>();
        // item1.put("title", "pencil");
        // item1.put("image", "https://imgur.com/qGQJ6UV");
        // item1.put("price", "2");
        // item1.put("quantity", "1");

        // HashMap<String, String> item2 = new HashMap<String, String>();
        // item2.put("title", "backpack");
        // item2.put("image", "https://imgur.com/D6eNwVV");
        // item2.put("price", "60");
        // item2.put("quantity", "1");

        // cart.add(item1);
        // cart.add(item2);

        VerticalLayout shoppingCartItems = new VerticalLayout();
        H3 h1 = new H3("Shopping Cart");
        h1.addClassName("h3");

        Button checkout = new Button("checkout", e ->{
            this.getUI().ifPresent(ui -> ui.navigate("/checkout"));
        });
        checkout.setClassName("button");

       
        shoppingCartItems.add(h1);
        for (HashMap<String, String> i: cart){
            HorizontalLayout horizontalSC = new HorizontalLayout();
           


            horizontalSC.setWidthFull();

            String cartUrl = i.get("image");
            
            TextArea title = new TextArea("Name");

            Image image = new Image(cartUrl, "shopping cart image");
            image.setHeight("150px");
            image.setWidth("150px");
            // TextField image = new TextField();
            TextField quantity = new TextField("Quantity");
            quantity.setWidth("50%");
            quantity.setHeight("50%");

            TextField price = new TextField("Price");
            price.setWidth("50%");
            price.setHeight("50%");

            Button removeFromCart = new Button("Remove from Cart", e->
            {
                for(int index=0; index < cart.size(); index++)
                {
                    if(cart.get(index).get("title").equals(i.get("title")))
                    {
                        cart.remove(index);
                        break;
                    }
                }

                currentSession.setAttribute("cart", cart);
                UI.getCurrent().getPage().reload();

            });
            
            removeFromCart.setClassName("button");


            title.setValue(i.get("title"));
            title.setReadOnly(true);
            // image.setTitle(i.get("image"));
            quantity.setValue(i.get("quantity"));
            quantity.setReadOnly(true);
            price.setValue(i.get("price"));
            price.setReadOnly(true);
            
            
            // layout for the quanitity and buttons
            Button plusButton = new Button("+",e->
            {
                for(int index=0; index < cart.size(); index++)
                {
                    if(cart.get(index).get("title").equals(i.get("title")))
                    {
                        int quant = Integer.parseInt(i.get("quantity"));
                        quant += 1;
                        cart.get(index).put("quantity", String.valueOf(quant));
                    }

                }

                currentSession.setAttribute("cart", cart);
                UI.getCurrent().getPage().reload();

            });

            plusButton.setWidth("10%");
            plusButton.setClassName("button");

            Button minusButton = new Button("-",e->{
                
                for(int index=0; index < cart.size(); index++)
                {
                    if(cart.get(index).get("title").equals(i.get("title")))
                    {
                        int quant = Integer.parseInt(i.get("quantity"));
                        quant -= 1;
                        if(quant == 0){
                            cart.remove(index);
                            break;
                        }
                        else{
                           cart.get(index).put("quantity", String.valueOf(quant));
                        }

                    }
                }
                    

                currentSession.setAttribute("cart", cart);
                UI.getCurrent().getPage().reload();

                
                
            });
            minusButton.setWidth("10%");
            minusButton.setClassName("button");

            HorizontalLayout quantLayout = new HorizontalLayout();
            quantLayout.add(minusButton, quantity, plusButton);
            quantLayout.setSpacing(false);
            quantLayout.setAlignItems(Alignment.BASELINE);


            // layout helps align removeFromCart
            HorizontalLayout priceLayout = new HorizontalLayout();
            priceLayout.add(price, removeFromCart);
            priceLayout.setSpacing(true);
            priceLayout.setAlignItems(Alignment.BASELINE);

            horizontalSC.addClassName("shoppingCartLayout");
            horizontalSC.add(image, title, quantLayout, priceLayout);
            horizontalSC.setJustifyContentMode(JustifyContentMode.START);
            horizontalSC.setAlignItems(Alignment.CENTER);

            shoppingCartItems.add(horizontalSC);

        }

        shoppingCartItems.add(checkout);
        add(shoppingCartItems);
        



        VerticalLayout recentlyAdded = new VerticalLayout();

        H3 header2 = new H3("Recently Viewed");
        header2.addClassName("h3");
        recentlyAdded.add(header2);

        for (HashMap<String, String> i: cart)
        {

            String recentUrl = i.get("image");

            VerticalLayout recentlyAddedItem = new VerticalLayout();


            TextArea recentlyViewed = new TextArea();
            recentlyViewed.setValue(i.get("title"));
            recentlyViewed.setReadOnly(true);
            recentlyViewed.setWidth("150px");
            recentlyViewed.setHeight("100px");

            Image recentImage = new Image(recentUrl,"Recently Viewed Image");
            recentImage.setHeight("200px");
            recentImage.setWidth("150px");
            recentlyAddedItem.addClassName("verticalLayout");
            recentlyAddedItem.add(recentlyViewed, recentImage);
            recentlyAddedItem.setAlignItems(Alignment.CENTER);
            recentlyAdded.add(recentlyAddedItem);


        }

        recentlyAdded.setAlignItems(Alignment.CENTER);
        add(recentlyAdded);

        


        } 


    }
    
