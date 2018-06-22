package mage.cards.a;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.BeginningOfCombatTriggeredAbility;
import mage.abilities.effects.common.continuous.BoostTargetEffect;
import mage.abilities.effects.common.continuous.GainAbilityTargetEffect;
import mage.abilities.keyword.IndestructibleAbility;
import mage.constants.SubType;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.TargetController;
import mage.filter.common.FilterControlledCreaturePermanent;
import mage.filter.predicate.mageobject.CardTypePredicate;
import mage.target.common.TargetControlledCreaturePermanent;

/**
 *
 * @author TheElk801
 */
public final class AetherShieldArtificer extends CardImpl {

    private static final FilterControlledCreaturePermanent filter
            = new FilterControlledCreaturePermanent("artifact creature you control");

    static {
        filter.add(new CardTypePredicate(CardType.ARTIFACT));
    }

    public AetherShieldArtificer(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{3}{W}");

        this.subtype.add(SubType.DWARF);
        this.subtype.add(SubType.ARTIFICER);
        this.power = new MageInt(3);
        this.toughness = new MageInt(3);

        // At the beginning of combat on your turn, target artifact creature you control gets +2/+2 and gains indestructible until end of turn.
        Ability ability = new BeginningOfCombatTriggeredAbility(
                new BoostTargetEffect(2, 2, Duration.EndOfTurn)
                        .setText("target artifact creature you control gets +2/+2"),
                TargetController.YOU, false
        );
        ability.addEffect(new GainAbilityTargetEffect(
                IndestructibleAbility.getInstance(),
                Duration.EndOfTurn
        ).setText("and gains indestructible until end of turn"));
        ability.addTarget(new TargetControlledCreaturePermanent(filter));
        this.addAbility(ability);
    }

    public AetherShieldArtificer(final AetherShieldArtificer card) {
        super(card);
    }

    @Override
    public AetherShieldArtificer copy() {
        return new AetherShieldArtificer(this);
    }
}