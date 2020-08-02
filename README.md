# NABU Interface: A Sustainable Approach to COVID-19 Using Risk Scores 
## Background and Contributors
NABU Interface was a solution designed by the COVID-19 Sustainable World New Technologies team for the NASA SEES 2020 Internship.

Research Team:
* Rohan Mhetar
* Samanyu Dixit
* Ryleigh Sibley

App Development Team:
* Ansh Nagwekar (Project Lead)
* William Huang
* David Muñiz

## Project Overview
During the COVID-19 pandemic, one of the largest issues society faces is an inability to track the virus. Currently, new technology - such as contact tracing - is being developed to root out potential sources of viral spread. As a team, we wanted to create an easy-to-use application that could display a person’s risk for COVID-19. To do this, we set three goals. First, we wanted to create an algorithm that takes user input and creates a risk score. Second, we wanted to incorporate NASA data in the application and algorithm. Finally, we wanted to create an interactive interface that would show the risk assessment in an easy-to-read and understandable way. 

## Research Approach and NABU Algorithm Design
We began by researching different factors that affect COVID-19 risk. We came up with a list of 40 inital factors and narrowed them down to 18. The final list included factors such as medical conditions (previous and ongoing), sanitation measures, and outdoor temperature, and we grouped them into 4 broad categories: personal factors, previous interactions, environmental factors and ongoing interactions. We utilized medical journals like NCBI to find biological information regarding COVID-19 as well as NASA data and satellite findings to assist in the research of environmental factors using data compiled from places like NASA’s Goddard Space Flight Center. After that, we assigned appropriate weights to all the factors based on impact and scientific consensus. Using these weights, we designed our algorithm to include numerous factors that contribute to one’s likelihood of contracting COVID-19. This algorithm is designed to calculate one’s initial NABU score based on personal factors, previous interactions and environmental factors. However, ongoing interactions will affect the NABU score every time an interaction form is submitted. This form should be filled out every time one goes out in public to ensure their latest NABU score is most reflective and accurate.

## Demo of the App
You can view a live demo of the app in the 5 minute video presentation our team put together for the [2020 SEES Virtual Showcase](https://www.youtube.com/watch?v=Yhn5nuYMDH4) that was hosted live on July 30-31, 2020. Skip to 28:30 for our presentation.

To run the app, please clone this repository and import to Android Studio, where you can run the source code and connect an Android device or emulator to display the app's user interface.

## Technical Features
This app was built in Android Studio, which mainly utilizes Java and XML to create Android applications. Our app includes the following features:
* Easy-to-navigate form UI that accomodates a large, diverse range of personal conditions, previous interactions, and environmental factors
* Generates risk score for COVID-19 susceptibiblity, transmissibility, and mortality based off factors derived from most current academic and medical research
* Enables user to add ongoing interactions and adjusts risk score accordingly
* Provides trustworthy and quality resources on COVID-19 that will be updated routinely
* Sustainable alternative to forms and hard copies for contact tracing
* Algorithm weights can be adjusted based on new research studies (since all calculations are handled by seperate Java file "RiskScore.java")
* Protects user data privacy since all form responses are stored locally and inaccessible by developers
* Input data is not mointored for accuracy, so users are responsible with sharing their conditions

## Improvements and Future Work
Given that we had about 3 weeks to complete the project and that our app development team had little experience with Android Studio (even though some of us were fairly well-versed in Java and had extensive programming experience), we had to limit the scope to complete a deliverable project. However, we had litsed out further improvements that we plan to make if we had more time to work on the app:
* Use it to detect other illnesses 
* Upgrade to a professional-grade detection software for contact tracing (to aid in filling out the form)
* Factor in the Risk Score of people involved in interactions to have a more accurate representation of impact of interaction on the user risk score
* Separate mortality score and risk score or make mortality score as a subscore
* Ask user for location, then calculate the rest of the values based on live datasets and implemented web scripts
* Automatically update environmental factors daily bases on live datasets
* Upload user data to an encrypted database and create user accounts
* Tune weights by partnering directly with COVID-19 researchers
* Share RiskScore algorithm with businesses, who can use people's NABU Score to decide whether they are safe enough to enter public places

## Significance
As COVID-19 continues to affect millions of lives, contact tracing is essential to slow the spread and currently relies heavily on paperwork and forms. In response, the app enables the general public to efficiently monitor their interaction activity and adjust their contact with people, and it migrates contact tracing to a sustainable, online alternative. In addition, as restaurants and public stores open, the risk of contracting COVID-19 increases. With widespread support for the app, businesses could start posting limitations based on an individual’s NABU score, and it could deter people from partaking in risky activities. Next, there is plenty of research left to complete on COVID-19 and its symptoms, and the flexibility of the NABU score algorithm enables developers to change weights and add factors easily for improved accuracy. Lastly, misinformation on COVID-19 swarms the Internet and important findings are often inaccessible to the public. Our app hopes to combat this misinformation with the “Additional Info” tab, which will only be filled with trustworthy and quality resources.

## Acknowledgements
We wish to express our gratitude to the NASA SEES program and the University of Texas at Austin for providing us this opportunity to further our passions, create new connections, expand our horizons, and grow as individuals. Special thanks to Mrs. Debbie Reynolds for mentoring us and the rest of the COVID-19 groups, Ms. Celena Miller and Ms. Margaret Baguio for setting up this wonderful internship and managing the 2020 Virtual Showcase, and Ms. Teresa Howard for making the SIP Python Data Science course available for all of the SEES interns!

## References
For a complete list of references, see the `references.txt` file in the repository.
