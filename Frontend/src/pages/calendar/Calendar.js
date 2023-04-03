import styles from "./calendar.module.css";
import Card from '@mui/material/Card';
const Calendar=()=>{

return(
<>
<div class={`${styles.container}`}>
    <Card variant="outlined" class={`${styles.calendar}`}>
        <h1 class={`${styles.h1}`}>Calendar</h1>
        <div class={`${styles.row}`}>

            <Card class={`${styles.card}`}>
                <h3 style={{margin: "0px"}}>January</h3>
                <p style={{margin: "2px"}}>Jan 1: New year</p>
            </Card>

            <Card class={`${styles.card}`}>
                <h3 style={{margin: "0px"}}>February</h3>
                <p style={{margin: "2px"}}>Feb 1 to 3: CNY</p>
            </Card>

            <Card class={`${styles.card}`}>March</Card>
        </div>

        <div class={`${styles.row}`}>
            <Card class={`${styles.card}`}>
                <h3 style={{margin: "0px"}}>April</h3>
                <p style={{margin: "2px"}}>15 April: Good Friday</p>
            </Card>

            <Card class={`${styles.card}`}>
                <h3 style={{margin: "0px"}}>May</h3>
                <p style={{margin: "2px"}}>1 May: Labour Day*</p> //2nd May
                <p style={{margin: "2px"}}>3 May: Hari Raya Puasa</p>
            </Card>

            <Card class={`${styles.card}`}>
                <h3 style={{margin: "0px"}}>June</h3>
            </Card>
        </div>

        <div class={`${styles.row}`}>
            <Card class={`${styles.card}`}>
                <h3 style={{margin: "0px"}}>July</h3>
                <p style={{margin: "2px"}}>10 July: Hari Raya Haji*</p> //11 july
            </Card>

            <Card class={`${styles.card}`}>
                <h3 style={{margin: "0px"}}>August</h3>
                <p style={{margin: "2px"}}>9 August: National Day</p>
            </Card>

            <Card class={`${styles.card}`}>September</Card>
        </div>

        <div class={`${styles.row}`}>
            <Card class={`${styles.card}`}>
                <h3 style={{margin: "0px"}}>October</h3>
                <p style={{margin: "2px"}}>24 October: Deepavali</p>
            </Card>
            <Card class={`${styles.card}`}>November</Card>
            <Card class={`${styles.card}`}>
                <h3 style={{margin: "0px"}}>December</h3>
                <p style={{margin: "2px"}}>25 December: Christmas Day*</p> //26
            </Card>
        </div>
        <h3>* Off in Lieu </h3>
    </Card>
</div>
</>
)
}

export default Calendar;