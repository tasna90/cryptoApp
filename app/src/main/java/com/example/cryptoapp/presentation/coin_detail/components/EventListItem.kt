package com.example.cryptoapp.presentation.coin_detail.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import com.example.cryptoapp.domain.model.CoinEvent

@Composable
fun EventListItem(
    event: CoinEvent,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = event.name,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.weight(7f)
            )
            Text(
                text = if (event.isConference) "conference" else "not conference",
                color = if (event.isConference) Color.Green else Color.Red,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(3f)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = if(!event.isConference) event.date else "${event.date} - ${event.dateTo}",
                style = MaterialTheme.typography.body2,
                fontStyle = FontStyle.Italic,
            )
        }

        Text(
            text = event.description,
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic
        )
    }
}