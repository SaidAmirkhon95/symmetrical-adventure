Library IEEE;
USE IEEE.Std_logic_1164.all;

entity piso_register is
    port(
        pinput : in std_logic_vector(3 downto 0);
        Clk : in std_logic;
        clear : in std_logic;
        write : in std_logic; -- write auf 1: es kann geschrieben werden. 
        sout : out std_logic
    );
end piso_register;

architecture behavioral of piso_register is
    component DFlipFlop is
        port(
            D : in std_logic;
            Clk : in std_logic;
            reset : in std_logic;
            Q : out std_logic
        );
    end component;

        -- ob paralle geschrieben oder seriel geschoben wird ist hier als 21mux implementiert 
        component mux21 is
            port(
                i1 : IN std_logic;
                i2 : IN std_logic;
                sel : IN std_logic; 
                y : OUT std_logic
            );
        end component;
    
    signal D_input1 : std_logic;	
	signal D_input2 : std_logic;
	signal D_input3 : std_logic;
	signal D_input4 : std_logic;
	
	signal mux1 : std_logic;
	signal mux2 : std_logic;
	signal mux3 : std_logic;
	
	signal output : std_logic;

    begin
        mux21_1 : mux21 port map (i1 => '1', i2 => write, sel => pinput(0), y => D_input1);
        D_ff1 : DFlipFlop port map (D => D_input1, Clk => Clk, reset => clear, Q => mux1);

        mux21_2 : mux21 port map (i1 => mux1, i2 => write, sel => pinput(1), y => D_input2);
        D_ff2 : DFlipFlop port map (D => D_input2, Clk => Clk, reset => clear, Q => mux2);		
    
	    mux21_3 :  mux21 port map (i1 => mux2, i2 => write, sel => pinput(2), y => D_input3);
        D_ff3 : DFlipFlop port map (D => D_input3, Clk => Clk, reset => clear, Q => mux3);
		
		mux21_4 :  mux21 port map (i1 => mux3, i2 => write, sel => pinput(3), y => D_input4);
        D_ff4 : DFlipFlop port map (D => D_input4, Clk => Clk, reset => clear, Q => output);
		
		sout <= output;

    end behavioral;
