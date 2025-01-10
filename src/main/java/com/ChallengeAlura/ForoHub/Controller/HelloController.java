package com.ChallengeAlura.ForoHub.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aldi")
public class HelloController {

    @GetMapping
    public String helloWorld() {
        return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Aldi</title>
                    <style>
                        body {
                            display: flex;
                            flex-wrap: wrap;
                            font-family: Arial, sans-serif;
                        }
                        .text {
                            margin: 10px;
                            transform: rotate(var(--rotation));
                        }
                    </style>
                </head>
                <body>
                    <div class="text" style="font-size: 10px; color: red; --rotation: 10deg;">Aldi</div>
                    <div class="text" style="font-size: 50px; color: blue; --rotation: -20deg;">Aldi</div>
                    <div class="text" style="font-size: 20px; color: green; --rotation: 30deg;">Aldi</div>
                    <div class="text" style="font-size: 70px; color: purple; --rotation: -40deg;">Aldi</div>
                    <div class="text" style="font-size: 15px; color: orange; --rotation: 50deg;">Aldi</div>
                    <div class="text" style="font-size: 100px; color: pink; --rotation: -60deg;">Aldi</div>
                    <div class="text" style="font-size: 25px; color: yellow; --rotation: 70deg;">Aldi</div>
                    <div class="text" style="font-size: 80px; color: brown; --rotation: -80deg;">Aldi</div>
                    <div class="text" style="font-size: 35px; color: cyan; --rotation: 90deg;">Aldi</div>
                    <div class="text" style="font-size: 60px; color: magenta; --rotation: -100deg;">Aldi</div>
                    <div class="text" style="font-size: 5px; color: lime; --rotation: 110deg;">Aldi</div>
                    <div class="text" style="font-size: 90px; color: navy; --rotation: -120deg;">Aldi</div>
                </body>
                </html>
                
                """;
    }

}

