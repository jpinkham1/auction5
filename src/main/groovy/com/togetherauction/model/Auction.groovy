package com.togetherauction.model

import java.text.DateFormat
import java.text.DecimalFormat
import java.text.SimpleDateFormat

class Auction extends ModelObject implements Serializable {

	private static final long serialVersionUID = 1L

	private String name
	private String fullName
	private Date eventOn
	private int activeDaysBefore = 120
	// computed fields below
	private Date activeFrom
	private Date activeThru
	private Date nextEventOn
	private Date prevEventOn
	private String liveOrder
	private int daysTill

	private String contactName
	private String contactEmail
    private BigDecimal fee, due
    private Date invoiced
    private Date paid

	Auction(final Integer id, final String name, final Date eventOn) {
		super(id)
		setName(name)
		setEventOn(eventOn)
	}

	boolean isCurrent() {
		return new Date().after(getActiveFrom())
				&& (getActiveThru() == null || new Date()
						.before(getActiveThru()))
	}

	String getName() {
		return name
	}

	void setName(final String name) {
		this.name = name
	}

	String getFullName() {
		return fullName
	}

	void setFullName(final String fullName) {
		this.fullName = fullName
	}

	Date getEventOn() {
		return eventOn
	}

	void setEventOn(final Date eventOn) {
		this.eventOn = eventOn
	}

	private static SimpleDateFormat fourDigitYearIfy(final SimpleDateFormat df) {
		final String pattern = df.toPattern().replaceFirst("yy|yyyy", "yyyy")
		return new SimpleDateFormat(pattern)
	}

	String getEventOnDateString() {
		return fourDigitYearIfy((SimpleDateFormat)DateFormat
				.getDateInstance(DateFormat.SHORT))
				.format(eventOn)
	}

	void setEventOnDateString(String s) {}

	String getEventOnDateTimeString() {
		return fourDigitYearIfy((SimpleDateFormat) DateFormat
				.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT))
				.format(eventOn)
	}

	void setEventOnDateTimeString(String s) {}

	String getNextAuctionDateTimeString() {
		return fourDigitYearIfy((SimpleDateFormat) DateFormat
				.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT))
				.format(nextEventOn)
	}

	void setNextAuctionDateTimeString(String s) {}

	String getNextAuctionActiveDateString() {
		return fourDigitYearIfy((SimpleDateFormat) DateFormat
				.getDateInstance(DateFormat.SHORT))
				.format(activeThru)
	}

	void setNextAuctionActiveDateString(String s) {}

	int getActiveDaysBefore() {
		return activeDaysBefore
	}

	void setActiveDaysBefore(final int activeDaysBefore) {
		this.activeDaysBefore = activeDaysBefore
	}

	Date getActiveFrom() {
		return activeFrom
	}

	void setActiveFrom(final Date activeFrom) {
		this.activeFrom = activeFrom
	}

	Date getActiveThru() {
		return activeThru
	}
	void setActiveThru(final Date activeThru) {
		this.activeThru = activeThru
	}

	Date getNextEventOn() {
		return nextEventOn
	}
	void setNextEventOn(final Date nextEventOn) {
		this.nextEventOn = nextEventOn
	}

	Date getPrevEventOn() {
		return prevEventOn
	}
	void setPrevEventOn(final Date prevEventOn) {
		this.prevEventOn = prevEventOn
	}

	String getLiveOrder() {
		return liveOrder
	}
	void setLiveOrder(final String liveOrder) {
		this.liveOrder = liveOrder
	}

    int getDaysAfter() {
        return -getDaysTill()
    }
	void setDaysAfter(final int daysAfter) {
		this.daysTill = -daysAfter
	}

	int getDaysTill() {
		return daysTill
	}
	void setDaysTill(final int daysTill) {
		this.daysTill = daysTill
	}

    BigDecimal getFee() {
        return fee
    }  // overridden value

    void setFee(BigDecimal fee) {
        this.fee = fee
    }

	BigDecimal getDue() {
		return fee != null ? fee : due != null ? due : BigDecimal.valueOf(75)
	}  // either 495 or 75

	void setDue(BigDecimal due) {
		this.due = due
	}

	String getPaypalLink() {
		DecimalFormat df = new DecimalFormat()
		df.setMaximumFractionDigits(2)
		df.setMinimumFractionDigits(0)
		df.setGroupingUsed(false)
		return "https://paypal.me/togetherauction/"+df.format(getDue())+"?locale.x=en_US"
	}

	Date getInvoiced() {
        return invoiced
    }

    void setInvoiced(Date invoiced) {
        this.invoiced = invoiced
    }

    Date getPaid() {
        return paid
    }

    void setPaid(Date paid) {
        this.paid = paid
    }

	String getContactName() {
		return contactName
	}

	void setContactName(final String contactName) {
		this.contactName = contactName
	}

	String getContactEmail() {
		return contactEmail
	}

	void setContactEmail(final String contactEmail) {
		this.contactEmail = contactEmail
	}

    @Override
	String toString() {
		return getName()
	}
}
