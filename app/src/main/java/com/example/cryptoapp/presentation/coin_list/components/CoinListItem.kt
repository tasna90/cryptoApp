package com.example.cryptoapp.presentation.coin_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.cryptoapp.domain.model.Coin
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun CoinListItem (
    coin: Coin,
    onItemClick: (Coin) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(coin) }
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(coin.image)
                .crossfade(true)
                .build(),
            contentDescription = coin.name,
            modifier = Modifier
                .weight(1f)
                .clip(CircleShape)
                .size(40.dp)
        )
        Column(
            modifier = Modifier
                .weight(6f)
                .absolutePadding(20.dp)
        ) {
            Text(
                text = "${coin.name} (${coin.symbol.uppercase()})",
                style = MaterialTheme.typography.h2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "Current price: ${coin.currentPrice} USD",
                style = MaterialTheme.typography.h4,
                color = Color.Yellow,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "24 hour high: ${coin.high24h} USD",
                style = MaterialTheme.typography.h4,
                color = Color.Yellow,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "24 hour low: ${coin.low24h} USD",
                style = MaterialTheme.typography.h4,
                color = Color.Yellow,
                overflow = TextOverflow.Ellipsis,
            )
        }
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .weight(3f)
        ) {
            Text(
                text = "${coin.priceChangePercentage24h}%",
                style = MaterialTheme.typography.h1,
                color = if(coin.priceChangePercentage24h.startsWith("-")) Color.Red else Color.Green,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}