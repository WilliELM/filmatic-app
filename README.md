# Movie-search app
by Maheen, Nicklas and William

## Introduktion
Vores emne er film/serier på streamingtjenester. Problemstilling lyder således; det kan være svært at finde frem til, hvor en bestemt film/serie kan streames. Vi vil derfor gerne undersøge, hvilke udfordringer der er med at finde film/serie på streamingtjenester, og hvordan kommer vores brugere frem til, hvor en ønsket film/serie kan ses. 

Vores målgruppe er personer, der benytter sig af streamingtjenester til dagligt til at se film og serier.  

Vi vil gerne hjælpe vores målgruppe ved at udvikle en app, som giver overblik over streamingplatforme til forskellige film og serier, så man ved, hvor en bestemt film el. serie kan ses. 

## Metoder
<details open>
  <summary> <b>Survey</b> </summary>
  
Vi har lavet survey, for at få kvantitative data. Vi har udsendt vores survey til vores netværk på Facebook. 35 personer besvarede vores survey. 

[Survey link](https://docs.google.com/forms/d/e/1FAIpQLSdpELD3fK4HUdkwh2NGcGHrtefLNEhr7sWw61sf08L07Oy16g/viewform?usp=sf_link)
  
  <img width="712" src="https://user-images.githubusercontent.com/111952804/233325828-13bc1a2a-c984-46f2-bd9f-a1bc41f13537.png">
   
   - En bred aldersgruppe fra 17- til 47-årige.
  
  - Mange har mere end 1 streamingtjeneste.
  
  <img width="712" src="https://user-images.githubusercontent.com/111952804/233326636-06ebc903-033c-4a9c-bd62-7b96aeac4aa0.png">
    
  - Flertallet benytter streamingtjenester flere gange dagligt.

  
  ```mermaid
  pie title Hvordan finder du ud af, hvor du kan streame en bestemt film eller serie?
    "Googler det" : 22
    "Kigger på min streamingtjeneste" : 4
    "Playpilot" : 4
  ```
  - Langt de fleste af brugerne søger på nettet, googling.

  ```mermaid
  pie title Hvad gør du, hvis du ikke kan finde den ønskede film eller serie?
    "Ser noget andet" : 17
    "Giver op" : 10
    "Køber/lejer den et andet sted" : 3
  
  ```
  
  - Halvdelen af brugerne oplever ikke udfordringer med søgning, mens den anden halvdel mener, at det kan være svært med forskellige titler på forskellige sprog, hvilket betyder, at det tager længere tid at finde film/serie, og at der kan kræves betaling.
  
  - Flertallet af brugerne ærgrer sig, bliver skuffede eller irriterede, hvis de ikke kan finde den ønskede film/serie, mens de resterende ikke oplever det som et stort problem.
  
  <img width="600" src="https://user-images.githubusercontent.com/111952804/233329136-5f4c9a50-f050-445d-b0c3-937ff6ee4fcb.png">
- Brugerne gør forskellige ting, når de ikke kan finde en ønsket film/serie, fx finder de en anden film på den platform, de bruger, leje eller køber den pågældende film på en anden platform, forsøger at finde den online eller opgiver helt.
  
 -Brugerne mener, at en forbedring kunne være:
1. overblik over hvor film/serie er tilgængelig.
2. god søgeplatform.
3. alt indhold samlet ét sted.  
</details>



<details open>
  <summary> <b>Observation</b> </summary>
  Vi har valgt observation for at be- eller afkræftelse besvarelsen af survey fra vores målgruppe. Vi vil undersøge, om der ligger mere bag besvarelserne, og tilføjer interview i observationen for at få nærmere forklaring af handlinger eller følelser fra brugeren. Vi iagttager, hvordan brugeren håndterer problemstillingen i sit naturlige miljø. 
  
Det har vi gjort ved at observere vores familier, når de søger efter en bestemt film eller serie.  
Observationsform: En blanding af naturlig og kontrolleret observation. Brugerne får en stillet opgave, der skal løses under et interview, hvor der stilles spørgsmål under opgaven. 
  
**Lokation:** Hjemme hos brugeren, i sit naturlige miljø, hvilket vil få brugeren vil agere mere naturligt i sin søgen.  
  
**Brugere:** Vores brugere er alle, der bruger streamingtjenester. 

**Fokus:** Personen skal finde ud af hvor, de kan se den givne film / serie, mens de undervejs fortæller, hvad de tænker og/eller føler. Vi fokuserer på hvilke platforme (google, IMDB, YT, Netflix m.m.) der åbnes, og hvilke tanker og følelser kommer der frem hos brugeren.
  
**Indsigter:**

Brugeren kigger først på streamingtjenesten, som benyttes allermest, dernæst andre tjenester som bruges mindre.  

Brugeren ærgrer sig over ikke at kunne finde den, men lader det ikke være et stort problem. Opgiver efter at have kigget på anden tjeneste. Brugeren udtaler: ”Der går for lang tid med at lede, det er selvfølgelig lidt irriterende ikke at vide, hvor den er tilgængelig, men så lad os bare se et eller andet på Netflix”. 

Brugeren ender med at finde en anden gratis tilgængelig film på streamingtjenesten, som benyttes mest.  
</details>


<details open>
  <summary> <b>Konklusion</b> </summary>
Et flertal af vores brugere benytter streamingtjenester flere gange dagligt.
Mange får negative følelser, når de ikke kan finde ud af, hvor en bestemt film/serie kan streames. 
Brugerne gør flere forskellige ting, hvis de ikke kan finde en film eller serie, som at finde en anden film/serie, lejer, finder den bestemte online eller opgiver helt.
Et flertal af brugerne udtrykker behov for et overblik over, hvor film/serie er tilgængelig, en god søgeplatform og alt indhold samlet på ét sted.
</details>

## User personas

**Billede 1**

**Billede 2**


## User journey map
<details open>  
  <summary>Diagram</summary>
  
  ```mermaid
  journey
    title User journey - Movie-streaming app
    section Day
      Wake up: 6: User
      Make breakfast: 6: User
      Do work: 3: User
      section Midday
      Colleague recommends movie: 5: User
      Done with work: 7: User
      Searches on Netflix for movie: 7: User
      Movie not found: 2: User
      Uses app to find where to watch: 4: User
    Finds out user can watch on HBO: 7: User
  
  ```
  
</details>


## User stories

<details open> <summary><b> User 1 </b></summary>
Bruger: 18-årig gymnasiedreng, ser realityprogrammer flere gange om ugen. 
Mål: at få overblik over, hvor det er gratis at streame.  
Motivation: at undgå at leje andre steder end streamingtjenesterne, som jeg allerede betaler for.  
</details>

<details open> <summary> <b>User 2</b></summary>
Bruger: 27-årig, færdiguddannet kandidat, som elsker at se klassiske film. 
Mål: at vide, hvor en bestemt film/serie kan streames. 
Motivation: at spare tid på at lede efter en ønsket film/serie og ikke lede det forkerte sted. 
</details>



## UX storyboard
<img width="712" alt="Skærmbillede 2023-04-17 kl  10 44 21" src="https://user-images.githubusercontent.com/111922379/232432813-f5792541-ff5c-4f0d-ad23-24856132f178.png">

## Beskrivelse af løsningen og processen
Vi startede med at lave et moodboard, som indeholder elementer som relaterer til vores emne. Så lavede vi et solution skecth med hvilket indhold og bruger- interaktivitet, vi ville have med i vores app, og byggede videre op i wireframe, som viser mere præcis placering af elementer og funktioner. Så arbejdede vi med styletile og mockup, som fører til vores endelige appløsning.
Vi ville gerne hjælpe vores brugere med at finde ud af, hvor en film kan streames, derfor har vi taget udgangspunkt i vores brugeres behov, og forsøgt at skabe en god søgeplatform samt overblik over tilgængelighed.

## Mood board
![1](https://user-images.githubusercontent.com/111922379/232430220-33859a11-115b-4d4e-9241-d07b29ed4fc1.png)

## Wireframe and Solution sketch
<img width="909" alt="Skærmbillede 2023-04-17 kl  10 45 18" src="https://user-images.githubusercontent.com/111922379/232433069-25d377c5-7e1f-4450-abf2-475b207e0011.png">

## Style tile
![2](https://user-images.githubusercontent.com/111922379/232430186-691ded6d-be10-4074-af62-6a0a89cb7135.png)

## Mockup
<img width="909" alt="Mockup of app" src="https://user-images.githubusercontent.com/111952804/233292481-e9bcf9b4-eba5-4668-b50b-c968477e7976.png">
