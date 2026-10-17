package com.example.realweek4

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.realweek4.R

data class Hero(
    val id: Int,
    val name: String,
    val rarity: String,
    val heroClass: String,
    val cp: Int,
    val level: Int,
    val currentHp: Int,
    val maxHp: Int,
    val currentMp: Int,
    val maxMp: Int,
    val atk: Int,
    val def: Int,
    val crit: String,
    val spd: Int,
    val skillName: String,
    val skillDesc: String,
    val imageRes: Int,
    val inSquad: Boolean = false,
    var isExpanded: Boolean = false
)

@Composable
fun PartyRosterApp() {
    val bgColor = Color(0xFF10131F)
    val cardColor = Color(0xFF1A1D2A)
    val yellowAccent = Color(0xFFFFC107)

    val heroes = remember {
        mutableStateListOf(
            Hero(1, "Alistair", "MYTHIC", "High Templar", 5600, 50, 1650, 1800, 650, 800, 380, 540, "22%", 105, "Wrath of the Heavens", "Calls down a celestial hammer, stunning all enemies for 3 seconds and taunting survivors.", R.drawable.berserker, false, false),
            Hero(2, "Theresa", "MYTHIC", "Divine Oracle", 5480, 49, 1100, 1200, 2100, 2400, 210, 300, "15%", 110, "Holy Light", "Heals all allies by 500 HP.", R.drawable.rogue, false, false),
            Hero(3, "Vespera", "MYTHIC", "Shadowblade", 5350, 48, 890, 950, 410, 600, 450, 200, "45%", 130, "Assassinate", "Deals massive damage to a single target.", R.drawable.paladin, false, false),
            Hero(4, "Elaria", "MYTHIC", "Archmage", 5120, 47, 450, 600, 1950, 2000, 500, 150, "30%", 100, "Meteor Strike", "Calls down a meteor on enemies.", R.drawable.cleric, true, false)
        )
    }

    val filters = listOf("All (14)", "Berserker (2)", "Archmage (3)", "Support (4)")
    var selectedFilter by remember { mutableStateOf(filters[0]) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(text = "Party Roster", color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Guild Vanguard • 14 Heroes Available", color = Color.Gray, fontSize = 12.sp)
                }
                Surface(
                    color = Color.Transparent,
                    border = BorderStroke(1.dp, yellowAccent),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(
                        text = "★ Expedition",
                        color = yellowAccent,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                }
            }
        }

        item {
            Card(
                colors = CardDefaults.cardColors(containerColor = cardColor),
                border = BorderStroke(1.dp, yellowAccent),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(modifier = Modifier.size(8.dp).clip(CircleShape).background(Color(0xFF4CAF50)))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("EXPEDITION SQUAD (3/4)", color = Color.Gray, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                        }
                        Text("⚔ 14750 CP", color = yellowAccent, fontWeight = FontWeight.Bold)
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Image(
                                painter = painterResource(id = heroes[0].imageRes),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.size(50.dp).clip(RoundedCornerShape(8.dp)).background(Color.White)
                            )
                            Image(
                                painter = painterResource(id = heroes[1].imageRes),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.size(50.dp).clip(RoundedCornerShape(8.dp)).background(Color.White)
                            )
                            Image(
                                painter = painterResource(id = heroes[2].imageRes),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.size(50.dp).clip(RoundedCornerShape(8.dp)).background(Color.White)
                            )

                            Box(
                                modifier = Modifier
                                    .size(50.dp)
                                    .background(Color(0xFF252836), RoundedCornerShape(8.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("+", color = Color.Gray, fontSize = 24.sp)
                            }
                        }

                        Button(
                            onClick ={ },
                            colors = ButtonDefaults.buttonColors(containerColor = yellowAccent),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text("Deploy ⚡", color = Color.Black, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }

        item {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Search by hero name, class, or rarity...", color = Color.Gray, fontSize = 14.sp) },
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = "Search Image",
                        modifier = Modifier.size(24.dp)
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = cardColor,
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = yellowAccent
                )
            )
        }

        item {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(filters) { filter ->
                    val isSelected = selectedFilter == filter
                    Surface(
                        color = if (isSelected) Color(0xFF3B3521) else cardColor,
                        border = if (isSelected) BorderStroke(1.dp, yellowAccent) else BorderStroke(1.dp, Color.Transparent),
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.clickable { selectedFilter = filter }
                    ) {
                        Text(
                            text = filter,
                            color = if (isSelected) yellowAccent else Color.Gray,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                            fontSize = 14.sp
                        )
                    }
                }
                item {
                    Text(
                        text = "Sort: Power",
                        color = yellowAccent,
                        modifier = Modifier
                            .background(cardColor, RoundedCornerShape(16.dp))
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        fontSize = 14.sp
                    )
                }
            }
        }

        items(heroes) { hero ->
            HeroCard(
                hero = hero,
                onCardClick = {
                    val index = heroes.indexOf(hero)
                    heroes[index] = hero.copy(isExpanded = !hero.isExpanded)
                }
            )
        }
    }
}

@Composable
fun HeroCard(hero: Hero, onCardClick: () -> Unit) {
    val cardColor = Color(0xFF1A1D2A)
    val yellowAccent = Color(0xFFFFC107)

    Card(
        colors = CardDefaults.cardColors(containerColor = cardColor),
        shape = RoundedCornerShape(16.dp),
        border = if (hero.inSquad) BorderStroke(1.dp, yellowAccent) else null,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onCardClick() }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Surface(color = Color(0xFFE91E63).copy(alpha = 0.1f), border = BorderStroke(1.dp, Color(0xFFE91E63)), shape = RoundedCornerShape(6.dp)) {
                        Text("MYTHIC", color = Color(0xFFE91E63), fontSize = 10.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
                    }
                    Surface(color = Color(0xFFFFC107).copy(alpha = 0.1f), border = BorderStroke(1.dp, Color(0xFFFFC107)), shape = RoundedCornerShape(6.dp)) {
                        Text(hero.heroClass.uppercase(), color = Color(0xFFFFC107), fontSize = 10.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
                    }
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("⚔ ${hero.cp} CP", color = yellowAccent, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    if (hero.inSquad) {
                        Spacer(modifier = Modifier.width(8.dp))
                        Surface(color = yellowAccent, shape = RoundedCornerShape(6.dp)) {
                            Text("IN SQUAD", color = Color.Black, fontSize = 10.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Box {
                    Image(
                        painter = painterResource(id = hero.imageRes),
                        contentDescription = hero.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(70.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color.White)
                    )

                    Surface(
                        color = Color(0xFF252836),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.align(Alignment.BottomEnd)
                    ) {
                        Text("Lvl ${hero.level}", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = hero.name, color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)

                        Image(
                            painter = painterResource(
                                id = if (hero.isExpanded) R.drawable.uparrow else R.drawable.downarrow
                            ),
                            contentDescription = "Expand",
                            colorFilter = ColorFilter.tint(Color.Gray),
                            modifier = Modifier.size(35.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    StatProgressBar(label = "HP", current = hero.currentHp, max = hero.maxHp, color = Color(0xFFE91E63))
                    Spacer(modifier = Modifier.height(6.dp))
                    StatProgressBar(label = "MP", current = hero.currentMp, max = hero.maxMp, color = Color(0xFF2196F3))
                }
            }

            if (hero.isExpanded) {
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    StatBox("ATK", hero.atk.toString(), Color(0xFFE91E63))
                    StatBox("DEF", hero.def.toString(), Color(0xFF4CAF50))
                    StatBox("CRIT", hero.crit, Color(0xFFFFC107))
                    StatBox("SPD", hero.spd.toString(), Color(0xFF03A9F4))
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "★ ${hero.skillName}", color = yellowAccent, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Text(text = hero.skillDesc, color = Color.Gray, fontSize = 12.sp, modifier = Modifier.padding(top = 4.dp))

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedButton(
                        onClick = { },
                        border = BorderStroke(1.dp, Color(0xFF4CAF50)),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.weight(1f).height(48.dp)
                    ) {
                        Text("✎ Heal (+250 HP)", color = Color(0xFF4CAF50))
                    }

                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        border = BorderStroke(1.dp, yellowAccent),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.weight(1f).height(48.dp)
                    ) {
                        Text("⚔ Add to Squad", color = yellowAccent)
                    }
                }
            }
        }
    }
}

@Composable
fun StatProgressBar(label: String, current: Int, max: Int, color: Color) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = label, color = Color.Gray, fontSize = 12.sp, modifier = Modifier.width(24.dp))

        Box(
            modifier = Modifier
                .weight(1f)
                .height(8.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(Color(0xFF252836))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(fraction = current.toFloat() / max.toFloat())
                    .background(color)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "$current / $max", color = Color.Gray, fontSize = 12.sp, modifier = Modifier.width(70.dp))
    }
}

@Composable
fun StatBox(title: String, value: String, color: Color) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color(0xFF252836), RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(text = title, color = color, fontSize = 11.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = value, color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PartyRosterPreview() {
    MaterialTheme {
        PartyRosterApp()
    }
}