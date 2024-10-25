const express = require('express');
const redis = require('redis');

const app = express();
const port = 3001;

// Redis client
const client = redis.createClient({
  host: 'localhost', 
  port: 6379  
});

app.use(express.json());

const SEAT_TTL = 60; 
(async () => {
  try {
    await client.connect();
  } catch (error) {
    console.error('Error connecting to Redis:', error);
  }
})();


app.post('/bookSeat', async (req, res) => {
  const { seatId } = req.body;

  try {
    const seatStatus = await client.get(seatId);

    if (seatStatus === null) {
        await client.setEx(seatId, SEAT_TTL, 'booked');

        // user has booked
        return res.status(200).json({ booked: true});
    } else {
        // already booked
        return res.status(400).json({ booked: false});
    }
} catch (error) {
    console.error('Booking error:', error);
    return res.status(500).json({ booked: false});
}
});

app.get('/getSeat/:seatId', async (req, res) => {
  const { seatId } = req.params;

  try {
    const seatStatus = await client.get(seatId);

    if (seatStatus) {
        // seat booked
      return res.status(200).json({booked: true });
    } else {
        // seat unbooked
      return res.status(404).json({ booked: false });
    }
  } catch (error) {
    return res.status(500).json({ booked: false});
  }
});


app.listen(port, () => {
  console.log(`Server running on http://localhost:${port}`);
});
