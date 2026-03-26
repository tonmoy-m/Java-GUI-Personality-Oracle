
package voice.of.oracle.v3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Home implements ActionListener, ItemListener{
    ImageIcon icon;
    ImageIcon image;
    
    JLabel labelTitle;
    JLabel pic;
    JLabel instruction;
    JPanel picbox;
    JPanel textbox;
    JFrame home;
    JButton go;
    
    JComboBox<String> dd;
    JComboBox<String> mm;
    String selectD;
    String selectM;
    
    Personality personality;
    
    Home(){
        icon = new ImageIcon("gideonL.png");
        image = new ImageIcon("home.png");
        
        labelTitle = new JLabel();
        labelTitle.setText("Voice of Oracle");
        labelTitle.setFont(new Font("Bauhaus 93",Font.BOLD,30));
        labelTitle.setVerticalAlignment(JLabel.CENTER);
        labelTitle.setHorizontalAlignment(JLabel.CENTER);
        
        pic = new JLabel();
        pic.setIcon(image);
        pic.setLayout(null);
        pic.setBounds(415, 40, 250, 250);

        
        instruction = new JLabel();
        instruction.setText("Please Select your Birthday");
        instruction.setFont(new Font("Agency FB",Font.PLAIN,20));
        //instruction.setVerticalAlignment(JLabel.CENTER);
        //instruction.setHorizontalAlignment(JLabel.CENTER);
        instruction.setBounds(405, 450, 250, 30);
        
        picbox = new JPanel();
        //picbox.setBackground(Color.red);
        picbox.setBounds(415, 40, 250, 250);
        picbox.setLayout(new BorderLayout());
        picbox.add(pic);
        
        textbox = new JPanel();
        //textbox.setBackground(Color.red);
        textbox.setBounds(370, 310, 250, 30);
        textbox.setLayout(new BorderLayout());
        textbox.add(labelTitle);
        
        //Drop Down
        String[] date = {"DD", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        dd = new JComboBox<>(date);
        dd.setBounds(400, 500, 50, 30);
        dd.addItemListener(this);
        
        String[] month = {"MM", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        mm = new JComboBox<>(month);
        mm.setBounds(475, 500, 100, 30);
        mm.addItemListener(this);
        
        
        home = new JFrame();
        home.setSize(1000, 800);
        home.setLayout(null);
        home.setVisible(true);
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        home.setTitle("Voice Of Oracle");
        //home.setIconImage(logo.getImage());
        home.setLocationRelativeTo(null);
        home.setIconImage(icon.getImage());
        
        go = new JButton("Show Result");
        go.setBounds(410, 600, 150, 30);
        go.addActionListener(this);
        
        home.add(picbox);
        home.add(textbox);
        home.add(instruction);
        home.add(dd); // date dropdown
        home.add(mm); // month dropdown
        home.add(go);
        
        personality = new Personality();
        
        // Force layout update 
        home.revalidate(); 
        home.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       if(e.getSource() == go) { 
           if (selectD == null || selectM == null) { 
               JOptionPane.showMessageDialog(home, "Please select both date and month.", "Error", JOptionPane.ERROR_MESSAGE); } 
           else { 
               home.dispose(); 
               personality.processInput(selectD, selectM); 
           } 
       }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if (e.getSource() == dd){
            selectD = (String) e.getItem();
        }
        else if(e.getSource() == mm){
            selectM = (String) e.getItem();
        }
    }
}

class Personality{
    void processInput(String date, String month){
        String logoPath  = "Default logo.png";
        String Sign = "Default Name";
        String ParagraphText = "Default Paragraph";
        
        int day = Integer.parseInt(date);
        if ((month.equals("January") && day >= 20) || (month.equals("February") && day <= 18)){
            logoPath = "aquarius1.png";
            Sign = "Aquarius";
            ParagraphText="You are an alien walking among us. You march to the beat of your own drum, always unapologetically yourself. No two of you are the same, so each time someone meets you, it’s a brand new, magical experience. You fascinate everyone. Your whole life, you’ve been unafraid to stand out, and this is why you grow into deeply authentic individuals. You might just be the sharpest. You are fascinated by new ideas and subjects. My advice? Never take you on in a debate, because others are likely to get torn apart by your meticulous wordsmithing. Your brain just seems to be on overdrive. You actually tend to get bored with basic, everyday conversation. When people get to know you, they’ll see that you have an amazing, loyal heart. But on the surface, you come off as distant, cool, and maybe even a little stand-offish. You just hate to deal with inauthenticity, so small talk and niceties are off the table. And though this sometimes earns you a reputation for being aloof, it also makes you fascinating to others. Much of the time, people become obsessed with winning you over. You are ruled by progress. Because of this, you obsess over how the world can become a better place, and how you can effect positive change. You might be super into social causes, or you might just constantly think of ways to improve your friends’ lives. In short, you are totally fueled by empathy, and it’s a big part of what makes you great. You are the self-assured, free spirit written about in epics. You truly don’t rely on anyone for anything—so if you keep someone around, it’s because they’re wanted, not needed. You aren’t afraid to create your own path and strike out on your own. You might choose to move somewhere new where you don’t know a soul, or you might feel comfortable staying in on Friday night to curl up with a riveting documentary. You are always unbothered. Trying to pull you into drama? You’re uninterested. Think you are about to stress out at the first sign of trouble? Think again. In this way, you radiate quiet confidence. Of course, it should be noted that you are totally capable of handling a crisis and taking down anyone foolish enough to challenge you. You just don’t need an audience! Some people don’t love your cool, detached behavior. In relationships, you are sometimes seen as too removed from your emotions, and too inexpressive. Your coolness can sometimes discourage new connections, and down the line, it might frustrate partners and close pals. You, contrary to popular belief, do experience feelings just like the rest of us—and even if it seems like a waste of time, you should consider sharing them.";
        }
        
        else if ((month.equals("February") && day >= 19) || (month.equals("March") && day <= 20)){
            logoPath = "pisces1.png";
            Sign = "Pisces";
            ParagraphText = "You are an ethereal and inward-facing empath. As someone who embodies the lessons and struggles central to every experience, you are the ultimate complex character. Beneath your calm, quirky exterior, your inner world is often turbulent. With you, there’s always more than meets the eye. People often mistake your sensitivity for simplicity; being underestimated is like your birthright. But you are perceptive, compassionate, and profound. It may not be politics or the periodic table that you know by heart, but if you know someone, you know what makes them tick, too. You are probably lowkey psychic—but luckily, you use your power for good. Expect tight hugs, flower crowns, poetry readings, and the most tenderhearted person in your contact list. Blurring the line between fantasy and reality is your second talent. When things get tough, you seek solace in daydreams. Because of this, you are gifted in resilience. But a tenuous relationship with the real world can have its challenges, too. Because you are such a capable daydreamer, you may struggle to invest in earthly responsibilities. This compels you to create amazing art, find rich spiritual fulfillment, and buck suffocating societal norms—but it may also create difficulty in your work and relationships. People find it easy to open up to you. Your empathetic nature allows you to understand others' feelings deeply, often without them even saying a word. You are like a sponge, absorbing emotions and sometimes finding it hard to separate your feelings from those of others. This emotional intelligence makes you an excellent friend and confidant, as people feel truly heard and understood when they talk to you. However, it also means you need time to recharge away from the noise of the world. Your creativity knows no bounds. Whether it’s painting, writing, music, or any other form of art, you excel at expressing your rich inner world. You see beauty in places where others might not, and your unique perspective is a breath of fresh air. Your artistic pursuits are not just hobbies; they are essential to your well-being. They provide an outlet for the emotions you so deeply feel and allow you to communicate with the world in a way that words sometimes cannot. Your presence is calming and soothing, much like a gentle breeze. People feel at ease around you, and your ability to make them feel safe and accepted is a rare gift. You have a way of bringing harmony and balance to any situation, and your friends and loved ones often turn to you for comfort and support. You are a beacon of light in a sometimes dark and chaotic world.";
        }
        
        else if ((month.equals("March") && day >= 21) || (month.equals("April") && day <= 19)){
            logoPath = "aries1.png";
            Sign = "Aries";
            ParagraphText = "You are passionate. You feel things deeply and openly, and the people in your inner circle know exactly how much you love them. That’s the beauty of your passionate heart: you don’t pretend to feel things you don’t, and you don’t keep cards close to your chest. All of the causes, people, hobbies, and ideas that you love, you love completely and fearlessly. You are bold. You aren’t afraid to go off the beaten path. Using sheer will and determination, you’ll forge your own trail in the brush. You go after what you want and aren’t afraid of staying quiet while you do. If you see someone you like across the room at a party, you won’t play it cool. You’ll walk right up to them, make solid eye contact, stick out a hand, and say: “Hi, I think we should get to know each other.” You are brave. You take pride in your willingness to tackle fears and take the fall for others. You stand in front of the group at the haunted house, and you’re the first to try the scariest roller coaster at the park. Then, you encourage your nervous friends to give it a whirl. In your mind, when you address your fears directly, you conquer them. You are confident. One of your greatest strengths is your self-assuredness. You believe that insecurity gets in the way of fun things and worthwhile accomplishments. Life is better when people feel free to be themselves, and this belief guides you throughout your journey. You sometimes get a rep for projecting confidence without forethought. You are energetic, industrious, and action-oriented. You never stop. Whether it’s sports, home improvement, work, or relationships, you are always pushing things forward. You believe in progress and improvement, and you work tirelessly to make that a major theme in your life. You are a natural leader, full of big ideas, and likely to lead the charge. You inspire the group to go out for a fun weekend adventure; you convince friends to open themselves up to new possibilities. You have faults, too. You are lively and spontaneous, and that’s a strength. But this can also give way to impatience when others aren’t willing to go at the same speed. And what makes you a great leader—your confidence—can also look like stubbornness on bad days. Plus, your 'now' mentality can leave you feeling easily frustrated, which can sometimes cause you to lash out.";
        }
        else if ((month.equals("April") && day >= 20) || (month.equals("May") && day <= 20)){
            logoPath = "taurus1.png";
            Sign = "Taurus";
            ParagraphText = "You are calm, stable, and super grounded. You come off as a reassuring force to others. In a crisis, you remain calm and cool under pressure. When the chips are down, you take a second to breathe, think things through meticulously, then confidently put forward a plan. On the flip side, you might be more subtle, preferring to organize behind the scenes. You are affectionate and romantic. Beauty, love, and romance are key to your nature. You know how to care for others, making every day feel a bit romantic, whether by bringing in flowers from the garden or sharing delicious chocolates with friends. When a friend is upset, you know when to throw an arm over their shoulder and assure them everything will be fine. You are graceful, gentle, and deliberate. Others see you as careful and poised, with a natural elegance in the way you move and speak. This contributes to the feeling of ease you offer in your connections, and it's totally effortless. Whether you’re dancing around the kitchen or removing an eyelash from a friend's cheek, your beauty is obvious. Friends often feel you have a magnetic, charming vibe. You lean into a quieter, more deliberate brand of charisma, making deep eye contact, speaking carefully, and asking insightful questions. When you decide to land a zinger at dinner, the timing is perfect and totally unexpected. However, you can also be stubborn. To many, you might come off as set in your ways, less go-with-the-flow than your friends would like. In your mind, you’ve thought everything through carefully and are sure of your decision, so why listen to anyone else? While that's fair, your circle would probably love to be heard, too. Compromise more with your pals; sometimes, it’s less about being right and more about making sure the people in your life feel like you care. You have a natural beauty and strength that’s undeniable. You have glowing, clear, or healthy-looking skin, appear strong and capable, have full, balanced features, and a symmetrical face.";
        }
        
        else if ((month.equals("May") && day >= 21) || (month.equals("June") && day <= 20)){
            logoPath = "gemini1.png";
            Sign = "Gemini";
            ParagraphText = "You are clever, a total brainiac who seems to know something about everything. Listening to you is like enjoying an educational podcast. Your brain isn’t just powerful—it’s quick, moving at the speed of light. As you navigate life’s path and encounter new challenges, you handle every curveball with grace. And if anyone doubts you, they’d be wise not to. You are defined by your curiosity. People, places, ideas—everything fascinates you. This hunger for knowledge carries you through life, from one interest to the next. When you listen to someone, you’re really listening, hanging onto their every word. This makes you one of the most interesting people around. You are playful and quick, a natural comic. Your personality is a perfect storm for humor: sharp enough to land one-liners but not taking yourself too seriously. The banter is always witty and impressions are on point. You stay surrounded by friends who love to laugh, keeping everyone in stitches. You are sunshine personified. You can make anyone feel like they could talk to you for hours, even spilling secrets. You’re an amazing friend and want to be friends with everyone, able to make conversation with anyone. You are the world’s BFF. You are versatile, a shapeshifter who feels like more than one person. In any city, any job, any friend group, you fit right in. You actually crave change and feel a strong urge to bolt if stuck with one thing for too long. This malleability is both your gift and your curse. You are a great communicator, a smooth talker, and a great listener. You have a special way with words, making others feel heard. In conversations, you always manage to get deep, even with new acquaintances, knowing how to ask all the right questions and mastering connection. However, it’s not always a walk in the park. You might have a hard time feeling comfortable in serious relationships, constantly craving new scenery and people. This makes it difficult to truly choose one person and stick around for the long haul. Your biggest fear is yourself—if emotions get too heavy, you hide them away, distancing yourself from others. Opening up a little could help bridge that gap.";
        }
        
        else if ((month.equals("June") && day >= 21) || (month.equals("July") && day <= 22)){
            logoPath = "cancer1.png";
            Sign = "Cancer";
            ParagraphText = "You are nurturing, often seen as a parent figure. You support, love, and mold those around you into the best versions of themselves. Your gentle nature and powerful heart make your hugs legendary. When everyone else leaves, you wait patiently, with tissues in hand, ready to love to the ends of the Earth. You are intuitive, reading emotions flawlessly, even from the subtlest clues. If someone is upset or joyous, you sense it and share in their feelings. Your uncanny ability to anticipate needs makes others wonder if you can read their thoughts. You are responsible, taking care of everyone—friends, siblings, and even acquaintances. You think of others constantly, packing extra snacks for hikes and making group dinner reservations. You love too much to let go of the reins, ensuring everyone is comfortable, happy, and having fun. You are tough, gentle and kind but ready to battle for loved ones when needed. Your sweetness hides great strength; you speak softly when someone has had a bad day, but you defend them fiercely when disrespected. You believe in feeling things deeply, experiencing big emotions, both highs and lows. This intensity allows you to enjoy happiness uniquely and fuels your rich creative life, likely making you talented in music, writing, art, or fashion. You are romantic, seeing beauty and meaning in everything, finding romance in everyday things like a sunset or a wildflower field. Your romantic nature is evident in how you perceive others, always seeing something unique and gorgeous in them. You have a deeply feeling nature that can lead to difficulties in love. You care so much for others—sometimes too much, leading you to micromanage friends and feel upset when unappreciated. Remembering that nobody’s perfect and lowering your sky-high standards can be the kindest thing you do for a friend.";
        }
        
        else if ((month.equals("July") && day >= 23) || (month.equals("August") && day <= 22)){
            logoPath = "leo1.png";
            Sign = "Leo";
            ParagraphText = "You are theatrical, a natural performer who dazzles and delights. Whether through storytelling, bold aesthetics, humor, or the arts, you find a way to shine. You hold people's full attention and transform everyday moments with joy and excitement. Even a mundane trip can become a fantastic tale in your hands. You are charismatic, never alone, as people flock to your playful, energetic, and warm company. Your goal isn't just to be liked but to be radiant, drawing everyone's eyes when you enter a room. You are passionate, all about the heart. While you may love luxury, your soul is pure, loving bravely and throwing your all into everything. You believe in fairytales and want an over-the-top, cinematic love story. You are loyal, fiercely protective of friends, defending them fiercely when needed. Though warm and dazzling, you are a true friend who is not to be messed with. You are generous, a great gift giver with a loving heart and an eye for material goods. You show your love through thoughtful presents, always ready to share and give. You are creative, with a keen artistic eye and a knack for creativity in various mediums. Your talent may crop up in surprising places, and your powerful artistic energy will lead to something great. However, your confidence can sometimes appear as self-obsession. You might get a bad rep for being too involved with yourself and your antics. The same things that make you special can be your downfall, so it's important to keep your ego in check, ensuring it doesn't eclipse your heart's efforts.";
        }
        
        else if ((month.equals("August") && day >= 23) || (month.equals("September") && day <= 22)){
            logoPath = "virgo1.png";
            Sign = "Virgo";
            ParagraphText = "You are organized, excellent at keeping things neat to avoid disorder and chaos. Whether it's arranging your room perfectly or using your extensive calendar for planning, you make a fantastic travel companion, team leader, and mentor. Sometimes, it’s important to go with the flow and accept invitations to unexpected events or fun times with friends. You are physically aware, perceptive, and have a beautiful relationship with yourself, listening to how your body feels and responding accordingly. Yoga, which offers a mind-body connection, might be a great fit for you. You are helpful, always ready to solve problems with your analytical thinking. You develop practical solutions and, though you may be candid, your honesty is meant to help, not hurt. Remember to be good to yourself too and take it easy when you’re worn down. You are hard-working, thriving on precision and accuracy, and you won’t give up until a job is done right. You are motivated and ambitious, with an almost never-ending stream of energy. Avoid burnout by regularly taking breaks, even a simple 5-minute walk can reset your stress levels. You are reserved, with a great personality that you don’t go out of your way to show off. Quiet and observant, you might be perceived as content to observe rather than be the center of attention. It can be scary to put yourself out there, but making an effort to strike up conversations in social settings can lead to fulfilling friendships. You are critical, pointing out problems, and having high standards for yourself and others. Be careful not to overly nitpick and try to let the little things go.";
        }
        
        else if ((month.equals("September") && day >= 23) || (month.equals("October") && day <= 22)){
            logoPath = "libra1.png";
            Sign = "Libra";
            ParagraphText = "You are known to be charming and refined. Your outward demeanor is often perceived as polite, diplomatic, and conflict-averse, avoiding trouble for yourself or others. You have an effortless charisma that draws people in, often coming across as flirtatious. Your sense of aesthetics and beauty, along with a stylish nature, make you stand out. You are intelligent, curious, and quick, with ideas that attract others. Your diplomatic nature allows you to navigate situations gracefully, striving for harmony and making those around you feel at ease. You avoid confrontation and are very accommodating, often rescheduling plans without fuss. Your charm makes you persuasive, able to win arguments with an unflappable demeanor. In relationships, you are romantic and supportive, preferring long-term commitments and feeling incomplete without a significant other. Your social skills make you a true social butterfly, engaging people in lively conversations and making them feel better. You just want to be liked, sometimes accommodating too much and having trouble saying no. You have a deep appreciation for beauty and the finer things in life, always well-groomed and stylish. However, you can be indecisive, considering all sides of an issue but struggling to make and stick to decisions. This desire for harmony makes you slow to act, often seeking reassurance even after making a choice.";
        }
        
        else if ((month.equals("October") && day >= 23) || (month.equals("November") && day <= 21)){
            logoPath = "scorpio1.png";
            Sign = "Scorpio";
            ParagraphText = "You are mysterious, complex, secretive, and alluring, making it difficult for people to truly read you. Just when someone feels they’ve scratched the surface, you throw a curveball, sending them off course. This is partly unintentional, as your complexity and depth make you difficult to know, but also a way to guard your deepest secrets due to your untrusting nature. You are loyal, a ride-or-die who offers intense dedication and protection to friends, family, and partners. You don’t back down in a fight and remain steadfast in the face of controversy, valuing meaningful relationships and taking them very seriously. You are intense, known for your passion and depth, making everyday moments feel rich and injecting life with meaning and emotion. Your intensity can be a gift to those closest to you, though it may be too much for some, leaving you feeling like a liability. You are strategic, viewing life as a game you’re clever enough to win. Sharp, detail-oriented, and intuitive, you notice subtle cues and signs others miss, always having a careful game plan in place. Whether attracting crushes, making friends, or excelling at work, your plan usually wins. You are determined, one of the hardest-working individuals who brings loyalty and intensity to everything you do. You won’t give up when the going gets tough, digging your heels in and holding onto things longer than you should. You are creative, intuitive, insightful, and intelligent, making you talented in the arts, whether music, poetry, or fashion. Your rich inner life fuels your creative expression, feeling natural like speaking a language you learned in another life. You are enticing, with a darkly enchanting allure and powerful natural sensuality that draws others in magnetically. Though you may not always seem obviously flirty or romantic, your movements carry an electric charge that’s hard to ignore. However, you are controlling, unforgiving, and jealous. Your strengths of intensity, passion, and strategic thinking can sometimes appear as manipulation. You might get a reputation for being too much in love, with an envious, unforgiving streak. Remember that your romances and friendships will be most rewarding when you love others without strings attached or strict expectations. Loosening the reins a bit will make you an even better partner and friend.";
        }
        
        else if ((month.equals("November") && day >= 22) || (month.equals("December") && day <= 21)){
            logoPath = "sagittarius1.png";
            Sign = "Sagittarius";
            ParagraphText = "You are adventurous, an explorer at heart, always on a quest to discover the mysteries of the world. You yearn for travel, whether it’s worldwide vagabonding or weekend trips to the next town over, finding fascination in every journey. This never-ending desire for exploration gives your life meaning. You are curious, a natural philosopher with an unquenchable thirst for knowledge and understanding. Art, culture, nature, and people all captivate you, making you more than just a charming personality but a student of the world. You are warm, often the life of every party, radiating kindness and comfort with your friendly, entertaining, and funny demeanor. Your bright eyes and beaming smile draw others in effortlessly. You are honest, seeking the deepest meaning in everyday life and having no taste for lies or dishonesty. You tell the brutal truth, making your words trustworthy, even if they sometimes sting. You are bold, believing the world is meant to be experienced, acting first and reflecting second, which leads to a life of excitement, wonder, and adventure. You are nomadic, constantly pulled to new fascinations, places, and people, never denying yourself life's joys and curiosities. This craving for new connections can strain older relationships. You are adaptable, a master of change, always ready for new excitement and resenting rigidness and routine. You see flexibility as your strength and freedom as your greatest gift.";
        }
        
        else if ((month.equals("December") && day >= 22) || (month.equals("January") && day <= 19)){
            logoPath = "capricorn1.png";
            Sign = "Capricorn";
            ParagraphText = "As the protector, planner, and pragmatic executive, you can be trusted to get the job done. You see life as a great, big project and are determined to excel, getting the highest marks in the class. Your success comes from an unparalleled work ethic, making you a powerhouse in professional and academic settings. This strength and resilience extend to every aspect of your life, including love. You never stop competing, especially with yourself, always striving to improve. This drive can lead to existential discontent, but finding perspective helps you manage feelings of inadequacy. In sex and love, you are consistent, showing up rain or shine, making your partner feel truly safe. Though you may have a cool exterior, you have a huge heart, offering affection through helping fine-tune logistics, being honest even when it's hard, and providing endless moral and protective support. Your conversation style may be less warm, but your intentions are always caring. In relationships, you tend to take the driver's seat indefinitely, confident in your decisions. This can cause strain, but with a patient partner, you can learn to let go a little. You are competitive, needing to be the best at everything, including intimacy, ensuring an earth-shattering experience for your partner. Your generosity knows no bounds, and you strive to be the best in all aspects, including love. Your partners appreciate your dedication and the sense of security you provide, while your determination and drive in all areas of life make you a formidable and inspiring companion.";
        }
        new Output(logoPath, Sign, ParagraphText);
    }
}

class Output{
    ImageIcon icon;
    
    JLabel labelName;
    JTextArea Para;
    JPanel logo;
    JPanel Result;
    JFrame output;
    Output(String logoPath, String Sign, String paragraphText){
        icon = new ImageIcon("gideonL.png");
        
        labelName = new JLabel();
        labelName.setText(Sign); // Change according to zodiac
        labelName.setFont(new Font("Segoe Script",Font.BOLD,30));
        //labelName.setVerticalAlignment(JLabel.CENTER);
        //labelName.setHorizontalAlignment(JLabel.CENTER);
        labelName.setBounds(370, 20, 250, 30);
        
        Para = new JTextArea(paragraphText);
        Para.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        Para.setLineWrap(true);
        Para.setWrapStyleWord(true);
        Para.setEditable(false);
        Para.setBackground(new Color(230, 230, 250));  // Same as Result background color

        
        logo = new JPanel();
        //logo.setBackground(Color.orange);
        logo.setBounds(10, 10, 50, 50);
        logo.setLayout(new BorderLayout());
        //picbox.add(label1);
        logo.add(new JLabel(new ImageIcon(logoPath)));
        
        Result = new JPanel();
        Result.setBackground(new Color(230, 230, 250));  // SlateGray
        //Result.setBounds(95, 65, 800, 600);
        Result.setBounds(45, 55, 900, 625);
        Result.setLayout(new BorderLayout());
        Result.add(Para, BorderLayout.CENTER);
        
        output = new JFrame();
        output.setSize(1000, 800);
        output.setLayout(null);
        output.setVisible(true);
        output.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        output.setTitle("My Personality");
        //output.setIconImage(logo.getImage());
        output.setLocationRelativeTo(null);
        output.setIconImage(icon.getImage());
        
        output.add(logo);
        output.add(labelName);
        output.add(Result);
        
    }
}

public class VoiceOfOracleV3 {

    
    public static void main(String[] args) {
        new Home();
    }
    
}
