import styles from "./calendar.module.css";
import Card from '@mui/material/Card';
const Calendar=()=>{

return(
<>
<div class={`${styles.container}`}>
    <Card variant="outlined" class={`${styles.calendar}`}>
        <h1 class={`${styles.h1}`}>Calendar</h1>
        <div class={`${styles.row}`}>

            <Card class={`${styles.card}`} style={{borderBottomColor: "#F08080", borderBottomStyle: "solid", borderWidth:"30px"}}>
                <h3 style={{margin: "0px"}}>January</h3>
                <p style={{margin: "2px"}}>Jan 1: New year</p>
            </Card>

            <Card class={`${styles.card}`} style={{borderBottomColor: "#FFDEB4", borderBottomStyle: "solid" ,borderWidth:"30px"}}>
                <h3 style={{margin: "0px"}}>February</h3>
                <p style={{margin: "2px"}}>Feb 1 to 3: CNY</p>
            </Card>

            <Card class={`${styles.card}`} style={{borderBottomColor: "#DFA67B", borderBottomStyle: "solid" ,borderWidth:"30px"}}>
                <h3 style={{margin: "0px"}}>March</h3>
            </Card>
        </div>

        <div class={`${styles.row}`}>
            <Card class={`${styles.card}`} style={{borderBottomColor: "#E5FDD1", borderBottomStyle: "solid" ,borderWidth:"30px"}}>
                <h3 style={{margin: "0px"}}>April</h3>
                <p style={{margin: "2px"}}>15 April: Good Friday</p>
            </Card>

            <Card class={`${styles.card}`} style={{borderBottomColor: "#FCC2FC", borderBottomStyle: "solid" ,borderWidth:"30px"}}>
                <h3 style={{margin: "0px"}}>May</h3>
                <p style={{margin: "2px"}}>1 May: Labour Day*</p>
                <p style={{margin: "2px"}}>3 May: Hari Raya Puasa</p>
            </Card>

            <Card class={`${styles.card}`} style={{borderBottomColor: "#EAC7C7", borderBottomStyle: "solid" ,borderWidth:"30px"}}>
                <h3 style={{margin: "0px"}}>June</h3>
            </Card>
        </div>

        <div class={`${styles.row}`}>
            <Card class={`${styles.card}`} style={{borderBottomColor: "#A0C3D2", borderBottomStyle: "solid" ,borderWidth:"30px"}}>
                <h3 style={{margin: "0px"}}>July</h3>
                <p style={{margin: "2px"}}>10 July: Hari Raya Haji*</p>
            </Card>

            <Card class={`${styles.card}`} style={{borderBottomColor: "#FD8A8A", borderBottomStyle: "solid" ,borderWidth:"30px"}}>
                <h3 style={{margin: "0px"}}>August</h3>
                <p style={{margin: "2px"}}>9 August: National Day</p>
            </Card>

            <Card class={`${styles.card}`} style={{borderBottomColor: "#9EA1D4", borderBottomStyle: "solid" ,borderWidth:"30px"}}>
                <h3 style={{margin: "0px"}}>September
                </h3>
            </Card>
        </div>

        <div class={`${styles.row}`}>
            <Card class={`${styles.card}`} style={{borderBottomColor: "#F08080", borderBottomStyle: "solid" ,borderWidth:"30px"}}>
                <h3 style={{margin: "0px"}}>October</h3>
                <p style={{margin: "2px"}}>24 October: Deepavali</p>
            </Card>

            <Card class={`${styles.card}`} style={{borderBottomColor: "#FFDEB4", borderBottomStyle: "solid" ,borderWidth:"30px"}}>
                <h3 style={{margin: "0px"}}>November</h3>
            </Card>

            <Card class={`${styles.card}`} style={{borderBottomColor: "#DFA67B", borderBottomStyle: "solid" ,borderWidth:"30px"}}>
                <h3 style={{margin: "0px"}}>December</h3>
                <p style={{margin: "2px"}}>25 December: Christmas Day*</p>
            </Card>
        </div>
        <div class={`${styles.row}`}>
            <p>*Off in Lieu: 2 May, 11 July, 26 December</p>
        </div>

    </Card>
</div>
</>
)
}

export default Calendar;